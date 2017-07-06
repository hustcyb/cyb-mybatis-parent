package com.cyb.spring.boot.mybatis.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cyb.spring.boot.mybatis.app.Application;
import com.cyb.spring.boot.mybatis.common.BeanUtils;
import com.cyb.spring.boot.mybatis.domain.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class StudentControllerTest {
	
	private MockMvc mvc;
	
	@Autowired
	private WebApplicationContext context;
	
	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testGetStudentSuccess() throws Exception {
		int id = 1;
		String uri = "/students/" + id;
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_UTF8))
				.andReturn();
		
		int status = result.getResponse().getStatus();
		assertEquals(status, 200);
		String content = result.getResponse().getContentAsString();
		Student student = BeanUtils.json2Bean(content, Student.class);
		assertNotNull(student);
		assertTrue(student.getId() == id);
		assertEquals(student.getName(), "Jim");
		assertTrue(student.getAge() == 10);
	}
	
}
