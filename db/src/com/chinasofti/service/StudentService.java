package com.chinasofti.service;

import java.util.List;

import com.chinasofti.dao.StudentDao;
import com.chinasofti.model.Student;

public class StudentService {
	
	private StudentDao studentDao = new StudentDao();

	public Student findStudent(String id) {
		return studentDao.queryStudent(id);
	}

	public List<Student> queryList(String name) {
		return studentDao.queryList(name);
	}

}
