package com.springboot.luobosi.smt;

import com.springboot.luobosi.smt.controller.SimpleController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
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
