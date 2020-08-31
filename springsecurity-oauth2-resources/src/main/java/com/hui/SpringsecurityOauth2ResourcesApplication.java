package com.hui;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hui.mapper")
public class SpringsecurityOauth2ResourcesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityOauth2ResourcesApplication.class, args);
	}

}
