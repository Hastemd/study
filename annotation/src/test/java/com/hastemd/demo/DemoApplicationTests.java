package com.hastemd.demo;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {

	public MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	@Before
	public void init() {
		mockMvc = MockMvcBuilders
				.webAppContextSetup(context)
				//.addFilter(new RequestWrapperFilter(), "/intf/*")
				.build();
	}

}
