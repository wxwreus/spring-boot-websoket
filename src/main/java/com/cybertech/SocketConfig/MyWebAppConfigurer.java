package com.cybertech.SocketConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by macprowuxiaowei on 2018/9/27.
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {


	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		System.out.println("=======");
		super.addResourceHandlers(registry);
	}
}
