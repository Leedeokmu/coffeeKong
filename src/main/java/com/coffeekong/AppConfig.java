package com.coffeekong;

import com.coffeekong.utils.MessageUtils;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.Ordered;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.MultipartConfigElement;
import javax.servlet.annotation.MultipartConfig;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Configuration
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, SessionAutoConfiguration.class})
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass=true)
@PropertySources({
		@PropertySource(name = "application", value = "classpath:application.properties"),
		@PropertySource(value="file:${properties_file}", ignoreResourceNotFound = true)
})
@MultipartConfig(maxFileSize = 10*1024*1024)
@SpringBootApplication
public class AppConfig  extends WebMvcConfigurerAdapter {
	public static void main(String[] args) {
//		System.setProperty("spring.devtools.restart.enabled", "false");
//		System.setProperty("spring.devtools.livereload.enabled", "true");
		SpringApplication.run(AppConfig.class, args);
	}


	// resource handler 등록
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("/");
		registry.addResourceHandler("/**/*.htm").addResourceLocations("/");
		registry.addResourceHandler("/**/*.js").addResourceLocations("/");
		registry.addResourceHandler("/**/*.css").addResourceLocations("/");
		registry.addResourceHandler("/**/*.jpg").addResourceLocations("/");
		registry.addResourceHandler("/**/*.jpeg").addResourceLocations("/");
		registry.addResourceHandler("/**/*.png").addResourceLocations("/");
		registry.addResourceHandler("/**/*.gic").addResourceLocations("/");
		registry.addResourceHandler("/**/*.ico").addResourceLocations("/");
		registry.addResourceHandler("/**/*.json").addResourceLocations("/");
		registry.addResourceHandler("/**/*.ttf").addResourceLocations("/");
	}
	// 초기화면 등록
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("redirect:/index");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		super.addViewControllers(registry);
	}


	// error page 추가 필요 : ServerpProperties 상속하여 구현
	@Bean
	public ServerProperties getServerProperteis() { return new ErrorPageCustomization();}
//	// 핸들러 매핑 추가
	@Bean
	public HandlerMapping handlerMapping(){
		RequestMappingHandlerMapping requestMappingHandlerMapping = new RequestMappingHandlerMapping();
		requestMappingHandlerMapping.setUseSuffixPatternMatch(true);
		return requestMappingHandlerMapping;
	}
	// message source
	@Bean
	public MessageSource messageSource(){
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setBasenames("classpath:messages");
		return messageSource;
	}

	@Bean
	public MessageUtils messageUtils(){
		MessageUtils messageUtils = new MessageUtils(messageSource());
		return messageUtils;
	}

	@Bean
	public LocaleResolver localeResolver(){
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.KOREA);
		return localeResolver;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		return localeChangeInterceptor;
	}
	// multipart 세팅

	@Bean
	public MultipartConfigElement multipartConfigElement(){
		MultipartConfigFactory factory = new MultipartConfigFactory();

		factory.setMaxFileSize(1024 * 1024 * 5);
		factory.setMaxRequestSize(1024 * 1024 * 5);
		return factory.createMultipartConfig();
	}

	@Bean
	public ScheduledExecutorService taskExecutor() { return Executors.newScheduledThreadPool(20); }

	@Bean
	public TaskScheduler taskScheduler() { return new ConcurrentTaskScheduler();}

	@Bean(name = "application")
	public PropertiesFactoryBean mapper() {
		PropertiesFactoryBean bean = new PropertiesFactoryBean();
		bean.setLocation(new ClassPathResource("application.properties"));
		return bean;
	}

	@Bean
	public ViewResolver viewResolver() {
		Map<String, MediaType> mediaTypes = new HashMap<>();
		mediaTypes.put("html", MediaType.TEXT_HTML);
		mediaTypes.put("json", MediaType.APPLICATION_JSON);

		ContentNegotiationManagerFactoryBean contentNegotiationManagerFactoryBean = new ContentNegotiationManagerFactoryBean();
		contentNegotiationManagerFactoryBean.addMediaTypes(mediaTypes);

		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setContentNegotiationManager(contentNegotiationManagerFactoryBean.getObject());

		List<View> defaultViews = new ArrayList<>();
		defaultViews.add(new MappingJackson2JsonView());
		resolver.setDefaultViews(defaultViews);
		resolver.setOrder(0);

		List<ViewResolver> viewResolvers = new ArrayList<>();
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		internalResourceViewResolver.setOrder(1);
		internalResourceViewResolver.setRequestContextAttribute("requestContext");
		viewResolvers.add(internalResourceViewResolver);
		resolver.setViewResolvers(viewResolvers);
		return resolver;
	}
}
