package com.cyb.spring.boot.mybatis.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyb.spring.boot.mybatis.common.api.ApiFunction;
import com.cyb.spring.boot.mybatis.common.api.ApiResult;
import com.cyb.spring.boot.mybatis.common.util.BeanUtils;
import com.cyb.spring.boot.mybatis.domain.Student;
import com.cyb.spring.boot.mybatis.service.StudentService;

/**
 * 学生控制器
 * 
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

	/**
	 * 获取学生
	 * 
	 * @param id
	 *            学生编号
	 * @return 学生
	 */
	@GetMapping("{id}")
	public ApiResult<Student> getStudent(@PathVariable("id") Integer id) {
		if (logger.isDebugEnabled()) {
			logger.debug("StudentController.getStudent: start, id = {}", id);
		}

		ApiResult<Student> result = ApiResult.execute(new ApiFunction<Student, Integer>() {

			@Override
			public Student execute(Integer parameter) {
				return studentService.getStudent(parameter);
			}
			
		}, id);
		if (logger.isDebugEnabled()) {
			logger.debug("StudentController.getStudent: end, return = {}",
					BeanUtils.bean2Json(result));
		}

		return result;
	}

	/**
	 * 保存学生
	 * 
	 * @param student
	 *            学生
	 * @return 学生编号
	 */
	@PostMapping
	public ApiResult<Integer> saveStudent(@RequestBody Student student) {
		if (logger.isDebugEnabled()) {
			logger.debug("StudentController.saveStudent: start, student = {}",
					BeanUtils.bean2Json(student));
		}

		ApiResult<Integer> result = ApiResult.execute(new ApiFunction<Integer, Student>() {

			@Override
			public Integer execute(Student parameter) {
				return studentService.saveStudent(parameter);
			}
			
		}, student);
		if (logger.isDebugEnabled()) {
			logger.debug("StudentController.saveStudent: end, return = {}",
					BeanUtils.bean2Json(result));
		}

		return result;
	}

	/**
	 * 更新学生
	 * 
	 * @param student
	 *            学生
	 */
	@PutMapping
	public ApiResult<Integer> updateStudent(@RequestBody Student student) {
		if (logger.isDebugEnabled()) {
			logger.debug(
					"StudentController.updateStudent: start, student = {}",
					BeanUtils.bean2Json(student));
		}

		ApiResult<Integer> result = ApiResult.execute(new ApiFunction<Integer, Student>() {

			@Override
			public Integer execute(Student parameter) {
				return studentService.updateStudent(parameter);
			}
			
		}, student);
		if (logger.isDebugEnabled()) {
			logger.debug("StudentController.updateStudent: end, return = {}", BeanUtils.bean2Json(result));
		}

		return result;
	}

	/**
	 * 删除学生
	 * 
	 * @param id
	 *            学生编号
	 */
	@DeleteMapping
	public ApiResult<Integer> deleteStudent(int id) {
		if (logger.isDebugEnabled()) {
			logger.debug("StudentController.deleteStudent: start, id = {}", id);
		}

		ApiResult<Integer> result = ApiResult.execute(new ApiFunction<Integer, Integer>() {

			@Override
			public Integer execute(Integer parameter) {
				return studentService.deleteStudent(parameter);
			}
			
		}, id);
		if (logger.isDebugEnabled()) {
			logger.debug("StudentController.deleteStudent: end, return = {}", BeanUtils.bean2Json(result));
		}
		
		return result;
	}
}
