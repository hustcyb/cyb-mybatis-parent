package com.cyb.spring.boot.mybatis.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cyb.spring.boot.mybatis.common.api.ErrorCodeEnum;
import com.cyb.spring.boot.mybatis.common.api.Preconditions;
import com.cyb.spring.boot.mybatis.common.util.BeanUtils;
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
	public Student getStudent(int id) {
		if (logger.isDebugEnabled()) {
			logger.debug("StudentService.getStudent: start, id = {}", id);
		}

		Student student = studentMapper.selectById(id);
		if (logger.isDebugEnabled()) {
			logger.debug("StudentServicde.getStudent: end, return = {}",
					BeanUtils.bean2Json(student));
		}
		return student;
	}

	/**
	 * 保存学生信息
	 * 
	 * @param student
	 *            学生
	 * @return 学生编号
	 */
	public Integer saveStudent(Student student) {
		if (logger.isDebugEnabled()) {
			logger.debug("StudentService.saveStudent: start, student = {}",
					BeanUtils.bean2Json(student));
		}

		checkStudent(student);
		studentMapper.insertSelective(student);
		Integer id = student.getId();
		if (logger.isDebugEnabled()) {
			logger.debug("StudentService.saveStudent: end, return = {}", id);
		}

		return id;
	}

	/**
	 * 更新学生
	 * 
	 * @param student
	 *            学生
	 */
	public int updateStudent(Student student) {
		if (logger.isDebugEnabled()) {
			logger.debug("StudentService.updateStudent: start, student = {}",
					BeanUtils.bean2Json(student));
		}

		checkStudent(student);
		Preconditions.checkArgument(student.getId() != null
				&& student.getId() > 0, ErrorCodeEnum.NULL_PARAMETER);

		int affectedRows = studentMapper.updateSelectiveById(student);
		if (logger.isDebugEnabled()) {
			logger.debug("StudentService.updateStudent: end, return = {}",
					affectedRows);
		}

		return affectedRows;
	}

	/**
	 * 删除学生
	 * 
	 * @param id
	 *            学生编号
	 */
	public int deleteStudent(int id) {
		if (logger.isDebugEnabled()) {
			logger.debug("StudentService.deleteStudent: start, id = {}", id);
		}

		int affectedRows = studentMapper.deleteById(id);
		if (logger.isDebugEnabled()) {
			logger.debug("StudentService.deleteStudent: end, return = {}",
					affectedRows);
		}

		return affectedRows;
	}

	/**
	 * 验证学生数据
	 * 
	 * @param student
	 *            学生
	 */
	private void checkStudent(Student student) {
		Preconditions.checkArgument(student != null,
				ErrorCodeEnum.NULL_PARAMETER);
		Preconditions.checkArgument(!StringUtils.isEmpty(student.getName()),
				ErrorCodeEnum.EMPTY_NAME);
		Preconditions.checkArgument(
				student.getAge() != null && student.getAge() > 0,
				ErrorCodeEnum.NULL_PARAMETER);
	}
}
