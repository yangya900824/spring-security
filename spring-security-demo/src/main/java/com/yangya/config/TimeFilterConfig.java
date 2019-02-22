package com.yangya.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yangya.filter.TimeFilter;
@Configuration
public class TimeFilterConfig {
	
	@Autowired
	private TimeFilter timeFilter;
	
	@Bean
	public FilterRegistrationBean filterRegistration(){
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(timeFilter);
		registration.addUrlPatterns("/*");
		return registration;
	}

}
