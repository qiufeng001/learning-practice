package com.learning.practice.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by LF on 2017/5/4.
 */
@Configuration
@EnableWebMvc
public abstract class AbstractWebMvcConfig extends WebMvcConfigurerAdapter {
	
	@Autowired
    Environment environment;

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		super.addArgumentResolvers(argumentResolvers);
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations(
				environment.getProperty("spring.resources.static-locations", "classpath:/static/"));

		super.addResourceHandlers(registry);
	}
}
