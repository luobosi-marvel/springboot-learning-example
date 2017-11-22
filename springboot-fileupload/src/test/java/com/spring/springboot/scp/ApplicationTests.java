package com.spring.springboot.scp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
// @WebAppConfiguration
// @ContextConfiguration(classes = Config.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void contextLoads() {
	}

	// @Test(timeout = 100) 如果加上时间限制可以测试超时操作(单位是毫秒)
	@Test
	public void test() throws Exception {
		this.mockMvc
				.perform(get("/toIndex"));
				//.andExpect(status().isOk());
	}

	@Test
	public void tests() {
		System.out.println(tes());
	}

	private int tes() {
		int m = 0;
		try {
			m += 1;
			return m;
		} catch (Exception e) {

		}finally {
			m += 2;
		}
		return m;
	}
}
