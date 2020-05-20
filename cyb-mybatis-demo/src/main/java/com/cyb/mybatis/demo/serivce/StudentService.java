package com.cyb.mybatis.demo.serivce;

import java.util.Collection;
import java.util.List;

import com.cyb.mybatis.demo.domain.Student;

/**
 * 学生服务
 * 
 * @author Administrator
 *
 */
public interface StudentService {

	/**
	 * 根据编号查询学生
	 * 
	 * @param id 编号
	 * @return 学生
	 */
	Student getById(Integer id);

	/**
	 * 根据编号聚合查询学生列表
	 * 
	 * @param ids 编号聚合
	 * @return 学生列表
	 */
	List<Student> listByIds(Collection<Integer> ids);

	/**
	 * 保存学生
	 * 
	 * @param student 学生
	 * @return 编号
	 */
	int save(Student student);

	/**
	 * 更新学生
	 * 
	 * @param student 学生
	 */
	void update(Student student);

	/**
	 * 根据编号删除学生
	 * 
	 * @param id 编号
	 */
	void deleteById(Integer id);
}
