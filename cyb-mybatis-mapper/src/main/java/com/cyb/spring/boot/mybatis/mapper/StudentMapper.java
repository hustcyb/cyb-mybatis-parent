package com.cyb.spring.boot.mybatis.mapper;

import com.cyb.spring.boot.mybatis.domain.Student;

/**
 * 学生数据仓库
 * 
 * @author Administrator
 *
 */
public interface StudentMapper {

	/**
	 * 根据编号查询学生
	 * 
	 * @param id 编号
	 * @return 学生
	 */
	Student selectById(int id);
}
