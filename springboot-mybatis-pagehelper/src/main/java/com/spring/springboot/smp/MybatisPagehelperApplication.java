package com.spring.springboot.smp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * MybatisPagehelperApplication 应用启动类
 *
 * @author luobosi@2dfire.com
 * @since 2017-11-22
 */
@SpringBootApplication
@MapperScan("com.spring.springboot.smp")
@ImportResource("classpath:mapper/*.xml")
public class MybatisPagehelperApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisPagehelperApplication.class, args);
	}
}
