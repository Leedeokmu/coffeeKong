package com.coffeekong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.annotation.MultipartConfig;

@Configuration
@EnableAutoConfiguration(exclude=#{DataSourceAutoConfiguration.class, SessionAutoConfiguration.class})
@EnableScheduling
@ComponentScan(basePackages = "com.coffeekong")
@EnableAspectJAutoProxy(proxyTargetClass=true)
@PropertySources({
		@PropertySource(name = "application", value = "classpath:applicaiton.properties"),
		@PropertySource(value="file:${properties_file}", ignoreResourceNotFound = true)
})
@MultipartConfig(maxFileSize = 10*1024*1024)
@SpringBootApplication
public class AppConfig  extends WebMvcConfigurerAdapter {
	public static void main(String[] args) { SpringApplication.run(AppConfig.class, args); }

	// resource handler 등록
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**/*.html").addResourceLocations("/");
		registry.addResourceHandler("/**/*.htm").addResourceLocations("/");
		registry.addResourceHandler("/**/*.js").addResourceLocations("/");
		registry.addResourceHandler("/**/*.css").addResourceLocations("/");
		registry.addResourceHandler("/**/*.jpg").addResourceLocations("/");
		registry.addResourceHandler("/**/*.jpeg").addResourceLocations("/");
		registry.addResourceHandler("/**/*.png").addResourceLocations("/");
		registry.addResourceHandler("/**/*.gic").addResourceLocations("/");
		registry.addResourceHandler("/**/*.ico").addResourceLocations("/");
		registry.addResourceHandler("/**/*.json").addResourceLocations("/");
		registry.addResourceHandler("/**/*.woff").addResourceLocations("/");
		registry.addResourceHandler("/**/*.woff2").addResourceLocations("/");
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
	public ServerProperties getServerProperteis() { return new ServerProperties();}
	@Bean
	public HandlerMapping handlerMapping(){
		RequestMapping
	}
}
