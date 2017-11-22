package com.spring.springboot.scp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 在 SpringBootApplication 上使用@ServletComponentScan 注解后，Servlet、Filter、Listener 可以直接通
 * 过 @WebServlet、@WebFilter、@WebListener 注解自动注册，无需其他代码。
 */
@SpringBootApplication
@ServletComponentScan
public class Application {


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
