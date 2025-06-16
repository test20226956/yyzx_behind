package com.neusoft.SP01;

import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neusoft.SP01.controller.UserController;

@SpringBootTest
class Sp01ApplicationTests {
	
	@Autowired
	private UserController uc;
	@Test
	void contextLoads() {
		
	}

}
