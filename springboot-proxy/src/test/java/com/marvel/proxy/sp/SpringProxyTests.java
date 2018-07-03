package com.marvel.proxy.sp;

import com.marvel.proxy.sp.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * SpringProxyTests 应用启动测试类
 *
 * @author luobosi@2dfire.com
 * @since 2018-06-30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringProxyTests {

	@Test
	public void contextLoads() {
	}

	@Resource
	private TestService testService;

	@Test
	public void test() {
		testService.sayHello();
	}

}
