package com.neusoft.SP01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.neusoft.SP01.dao")
public class Sp01Application {

	public static void main(String[] args) {
		SpringApplication.run(Sp01Application.class, args);
	}

}
