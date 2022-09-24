package com.taoism.discipline;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.taoism.discipline.mapper")
public class DisciplineApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisciplineApplication.class, args);
	}
}
