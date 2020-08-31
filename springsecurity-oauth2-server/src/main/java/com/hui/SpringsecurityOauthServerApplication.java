package com.hui;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hui.mapper")
public class SpringsecurityOauthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityOauthServerApplication.class, args);
	}

}
