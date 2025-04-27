package com.fengzhu.mpDemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAsync
@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
@MapperScan(value = "com.fengzhu.mpDemo.mapper")
public class MpDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MpDemoApplication.class, args);
	}

}
