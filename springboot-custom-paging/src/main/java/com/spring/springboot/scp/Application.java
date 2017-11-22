package com.spring.springboot.scp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Application  应用启动类
 *
 * @author luobosi@2dfire.com
 * @since 2017-11-22
 */
@SpringBootApplication
@MapperScan("com.spring.springboot.scp")
@ImportResource("classpath:mapper/*.xml")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
