package com.chinasofti.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.chinasofti.db.DbUtil;
import com.chinasofti.model.Student;

public class StudentDao {

	@Test
	public void query() {
		List<Student> list = queryList("À×");
		if(list.size() != 0) {
			for(Student stu : list) {
				System.out.println(stu.getName());
			}
		}
	}

	public Student queryStudent(String id) {
		Student student = null;
		DbUtil dbUtil = new DbUtil();
		try {
			Statement stm = dbUtil.getStatement();
			String sql = "select * from student where id = '" + id + "'";
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next()) {
				student = new Student();
				student.setId(rs.getString("id"));
				student.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeConnection();
		}
		return student;
	}
	
	public List<Student> queryList(String name) {
		List<Student> list = new ArrayList<Student>();
		DbUtil dbUtil = new DbUtil();
		try {
			Statement stm = dbUtil.getStatement();
			String sql = "select * from student where name like '%" + name + "%'";
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getString("id"));
				student.setName(rs.getString("name"));
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeConnection();
		}
		return list;
	}

}
