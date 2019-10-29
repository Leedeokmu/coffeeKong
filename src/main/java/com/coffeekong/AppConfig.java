package com.coffeekong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@EnableCaching
@SpringBootApplication
public class AppConfig  implements WebMvcConfigurer {
	public static void main(String[] args) {
		SpringApplication.run(AppConfig.class, args);
	}

	// resource handler 등록
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**/*").addResourceLocations("classpath:/templates/");
	}

	@Bean
	public ScheduledExecutorService taskExecutor() { return Executors.newScheduledThreadPool(20); }

	@Bean
	public TaskScheduler taskScheduler() { return new ThreadPoolTaskScheduler();}
}
