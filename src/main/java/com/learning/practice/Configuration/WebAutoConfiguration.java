package com.learning.practice.Configuration;

import com.learning.practice.dao.UserRepository;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackageClasses = { UserRepository.class })
public class WebAutoConfiguration {
	public WebAutoConfiguration() {

	}
	
	public static void main(String[] args) {
		System.out.println("init config...");
	}
}
