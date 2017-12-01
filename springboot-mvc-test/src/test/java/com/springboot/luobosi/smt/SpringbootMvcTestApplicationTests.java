package com.springboot.luobosi.smt;

import com.springboot.luobosi.smt.controller.SimpleController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;

/**
 * SpringbootMvcTestApplicationTests
 *
 * 注意，这里会遇到一个问题：如果一开始就是用下面三个注解会报错，
 * 原因就是 @SpringBootTest 和 @ WebMvcTest 不能同时使用
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-01
 */
@RunWith(SpringRunner.class)
// @SpringBootTest(classes = SpringbootMvcTestApplication.class)
@WebMvcTest(SimpleController.class)
public class SpringbootMvcTestApplicationTests {

	@Resource
	private MockMvc mockMvc;

	/**
	 * MockMvc API 详解
	 *
	 * perform: 执行一个 RequestBuilder 请求，会自动执行 SpringMVC 的流程并映射到相应的控制器执行处理；
	 * addExpect: 添加 ResultMatcher 验证规则，验证控制器执行完成后结果是否正确
	 * andDo: 添加 ResultHandler 结果处理器，比如调试时打印结果到控制台；
	 * andReturn: 最后返回相应的 MvcResult; 然后进行自定义验证/进行下一步的异步处理
	 *
	 * @throws Exception  异常
	 */
	@Test
	public void testIndex() throws Exception{
		String expectedResult = "index";
		String uri = "/index";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println("marvel:" + content);
		assertEquals(200, status);
		assertEquals(expectedResult, content);
	}



}
