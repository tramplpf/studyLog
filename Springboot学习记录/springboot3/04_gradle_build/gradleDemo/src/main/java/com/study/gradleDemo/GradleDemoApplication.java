package com.study.gradleDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GradleDemoApplication {

	private static final Logger log = LoggerFactory.getLogger(GradleDemoApplication.class);
	public static void main(String[] args) {
		log.info("Gradle 构建项目springboot项目开始启动");
		SpringApplication.run(GradleDemoApplication.class, args);
		log.info("Gradle 构建项目springboot项目启动完成...");
	}

}
