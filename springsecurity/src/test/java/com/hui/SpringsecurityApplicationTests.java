package com.hui;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;

@SpringBootTest
class SpringsecurityApplicationTests {

	@Test
	void contextLoads() {
		String pwd = BCrypt.hashpw("123", BCrypt.gensalt());
		System.out.println(pwd);
	}

}
