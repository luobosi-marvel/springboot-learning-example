package com.spring.springboot;

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

	/**
	 * 使用代码注册Servlet（不需要@ServletComponentScan注解）
	 */
/*	public ServletRegistrationBean servletRegistrationBean() {
		return new ServletRegistrationBean(new MyServlet(), "/xs/*"); // ServletName 默认值字母小写，即 myServlet
	}*/


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
