package com.cyb.mybatis.demo.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyb.mybatis.demo.domain.Student;
import com.cyb.mybatis.demo.serivce.StudentService;

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
	 * 学生数据仓库
	 */
	@Autowired
	private StudentService studentService;

	@GetMapping("{id:\\d+}")
	public Student getById(@PathVariable Integer id) {
		return studentService.getById(id);
	}

	@GetMapping("{ids:\\d+,[,\\d]*}")
	public List<Student> listByIds(@PathVariable Collection<Integer> ids) {
		return studentService.listByIds(ids);
	}

	@PostMapping
	public Integer save(@RequestBody Student student) {
		return studentService.save(student);
	}

	@PutMapping("{id}")
	public void update(@PathVariable Integer id, @RequestBody Student student) {
		Optional.of(student).ifPresent(stu -> stu.setId(id));
		studentService.update(student);
	}

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable Integer id) {
		studentService.deleteById(id);
	}

}
