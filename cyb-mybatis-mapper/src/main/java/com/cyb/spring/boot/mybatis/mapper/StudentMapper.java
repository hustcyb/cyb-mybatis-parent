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
	 * @param id
	 *            编号
	 * @return 学生
	 */
	Student selectById(int id);

	/**
	 * 选择性插入学生数据
	 * 
	 * @param student
	 *            学生
	 * @return 影响记录数目
	 */
	int insertSelective(Student student);

	/**
	 * 选择性更新学生信息
	 * 
	 * @param student
	 *            学生
	 * @return 影响记录数目
	 */
	int updateSelectiveById(Student student);
	
	/**
	 * 删除学生
	 * @param id 学生编号
	 * @return 影响记录数目
	 */
	int deleteById(int id);
}
