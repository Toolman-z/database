package com.chinasofti.controller;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.chinasofti.model.Student;
import com.chinasofti.service.StudentService;

public class StudentController {
	
	StudentService studentService = new StudentService();
			
	public String findStudent(String id) {
		Student stu =  studentService.findStudent(id);
		return JSON.toJSONString(stu);
	}
	
	public List<Student> queryList(String name){
		List<Student> list = studentService.queryList(name);
		System.out.println(JSON.toJSONString(list));
		return list;
	}

}
