package com.coffeekong;

import com.coffeekong.utils.MessageUtils;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@EnableCaching
@SpringBootApplication
public class AppConfig  {
	public static void main(String[] args) {
		SpringApplication.run(AppConfig.class, args);
	}

	@Bean
	public MessageSource messageSource(){
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setBasenames("classpath:messages");
		return messageSource;
	}

	@Bean(name="coffeekongMessageUtils")
	public MessageUtils messageUtils(){
		MessageUtils messageUtils = new MessageUtils(messageSource());
		return messageUtils;
	}

	@Bean
	public ScheduledExecutorService taskExecutor() { return Executors.newScheduledThreadPool(20); }

	@Bean
	public TaskScheduler taskScheduler() { return new ThreadPoolTaskScheduler();}

	@Bean(name = "application")
	public PropertiesFactoryBean mapper() {
		PropertiesFactoryBean bean = new PropertiesFactoryBean();
		bean.setLocation(new ClassPathResource("application.properties"));
		return bean;
	}

}
