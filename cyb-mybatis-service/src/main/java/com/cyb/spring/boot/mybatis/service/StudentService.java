package com.cyb.spring.boot.mybatis.service;

import javax.annotation.Resource;

import org.assertj.core.util.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cyb.spring.boot.mybatis.common.BeanUtils;
import com.cyb.spring.boot.mybatis.domain.Student;
import com.cyb.spring.boot.mybatis.mapper.StudentMapper;

/**
 * 学生服务
 * 
 * @author Administrator
 *
 */
@Service
public class StudentService {

	/**
	 * 日志接口
	 */
	private static Logger logger = LoggerFactory
			.getLogger(StudentService.class);

	/**
	 * 学生数据仓库
	 */
	@Resource
	private StudentMapper studentMapper;

	/**
	 * 根据记录编号获取学生信息
	 * 
	 * @param id
	 *            记录编号
	 * @return 学生信息
	 */
	public Student getStudent(Integer id) {
		logger.debug("StudentService.getStudent: start, id = {}", id);
		Preconditions.checkNotNull(id, "学生编号不能为空");

		Student student = studentMapper.selectById(id);
		
		logger.debug("StudentServicde.getStudent: end, return = {}", BeanUtils.bean2Json(student));
		return student;
	}
}
