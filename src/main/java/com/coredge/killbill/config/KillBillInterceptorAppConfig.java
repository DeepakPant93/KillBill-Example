package com.coredge.killbill.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class KillBillInterceptorAppConfig implements WebMvcConfigurer {

	@Autowired
	private HeaderRequestHandler headerRequestHandler;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(headerRequestHandler);
	}
}