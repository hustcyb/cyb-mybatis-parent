package com.cyb.mybatis.demo.persistence;

import java.util.Collection;
import java.util.List;

import com.cyb.mybatis.demo.domain.Student;

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
	Student selectById(Integer id);

	/**
	 * 根据编号聚合删除学生
	 * 
	 * @param ids 编号聚合
	 * @return 学生
	 */
	List<Student> selectByIds(Collection<Integer> ids);

	/**
	 * 选择性新增学生
	 * 
	 * @param student 学生
	 * @return 新增记录数目
	 */
	int insertSelective(Student student);

	/**
	 * 根据编号选择性更新学生
	 * 
	 * @param student 学生
	 * @return 更新记录数目
	 */
	int updateSelectiveById(Student student);

	/**
	 * 根据编号删除学生
	 * 
	 * @param id 编号
	 * @return 删除记录数目
	 */
	int deleteById(Integer id);

}
