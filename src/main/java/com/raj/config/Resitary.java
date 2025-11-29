package com.raj.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.raj.enterseptor.TimeEnterseptor;

@Configuration
public class Resitary implements WebMvcConfigurer {
	@Autowired
	private TimeEnterseptor time;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(time);
		
	}

}
