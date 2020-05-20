package com.cyb.mybatis.demo.serivce.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.cyb.mybatis.demo.domain.Student;
import com.cyb.mybatis.demo.persistence.StudentMapper;
import com.cyb.mybatis.demo.serivce.StudentService;

/**
 * 学生服务实现
 * 
 * @author Administrator
 *
 */
@Service
public class StudentServiceImpl implements StudentService {

	/**
	 * 学生仓库
	 */
	@Autowired
	private StudentMapper studentMapper;

	@Override
	public Student getById(Integer id) {
		if (id == null) {
			return null;
		}
		
		return studentMapper.selectById(id);
	}

	@Override
	public List<Student> listByIds(Collection<Integer> ids) {
		if (CollectionUtils.isEmpty(ids)) {
			return Collections.emptyList();
		}
		
		return studentMapper.selectByIds(ids);
	}

	@Override
	public int save(Student student) {
		checkStudent(student, false);
		
		studentMapper.insertSelective(student);
		return student.getId();
	}

	@Override
	public void update(Student student) {
		checkStudent(student, true);
		
		studentMapper.updateSelectiveById(student);
	}

	@Override
	public void deleteById(Integer id) {
		checkId(id);
		studentMapper.deleteById(id);
	}
	
	public void checkStudent(Student student, boolean checkingId) {
		Assert.notNull(student, "请指定学生数据");
		if (checkingId) {
			checkId(student.getId());
		}
		
		Assert.isTrue(!StringUtils.isEmpty(student.getName()), "请指定姓名");
		Assert.notNull(student.getAge(), "请指定年龄");
	}
	
	/**
	 * 验证编号
	 * 
	 * @param id 编号
	 */
	private void checkId(Integer id) {
		Assert.notNull(id, "请指定编号");
	}

}
