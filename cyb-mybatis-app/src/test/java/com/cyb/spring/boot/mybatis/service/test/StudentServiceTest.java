package com.cyb.spring.boot.mybatis.service.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cyb.spring.boot.mybatis.app.Application;
import com.cyb.spring.boot.mybatis.domain.Student;
import com.cyb.spring.boot.mybatis.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class StudentServiceTest {

	@Resource
	private StudentService studentService;
	
	@Test
	public void testGetStudentReturnsNullIfNotExists() {
		Integer id = -1;
		Student student = studentService.getStudent(id);
		
		assertNull(student);
	}
	
	@Test
	public void testGetStudentSuccessIfExists() {
		Integer id = 1;
		Student student = studentService.getStudent(id);
		
		assertNotNull(student);
		assertEquals(id, student.getId());
	}
}
