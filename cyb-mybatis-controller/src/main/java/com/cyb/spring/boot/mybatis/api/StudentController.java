package com.cyb.spring.boot.mybatis.api;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cyb.spring.boot.mybatis.common.BeanUtils;
import com.cyb.spring.boot.mybatis.domain.Student;
import com.cyb.spring.boot.mybatis.service.StudentService;

/**
 * 学生控制器
 * @author Administrator
 *
 */
@RequestMapping("students")
@RestController
public class StudentController {
	
	/**
	 * 日志接口
	 */
	private Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	/**
	 * 学生数据仓库
	 */
	@Resource
	private StudentService studentService;
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Student get(@PathVariable("id") Integer id) {
		logger.debug("StudentController.get: start, id = {}", id);
		Student student = studentService.getStudent(id);
		
		logger.debug("StudentController.get: end, return = {}", BeanUtils.bean2Json(student));
		return student;
	}
}
