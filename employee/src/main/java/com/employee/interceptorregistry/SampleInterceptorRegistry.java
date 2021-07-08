package com.employee.interceptorregistry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.employee.interceptor.SampleInterceptor;

@Component
public class SampleInterceptorRegistry extends WebMvcConfigurerAdapter {


	@Autowired
	SampleInterceptor sampleInterceptor; 
	
	@Override
	public void addInterceptors(InterceptorRegistry interceptorRegistry) {
		interceptorRegistry.addInterceptor(sampleInterceptor);
	
	}

	
}
