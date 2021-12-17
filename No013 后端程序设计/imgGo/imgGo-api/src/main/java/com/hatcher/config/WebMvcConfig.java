package com.hatcher.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: HatcherCheung
 * @Date: 2021/12/6
 * @Description:
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	/**
	 * 实现静态资源的映射
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 映射本地的静态资源
		registry.addResourceHandler("/**")
				.addResourceLocations("file:/E:\\images\\user_upload\\");
		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/");

	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
