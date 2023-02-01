package com.esspl.api.studentmanagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.esspl.api.studentmanagement.model.Student;

@Repository
public class JdbcRepository implements StudentRepository {

	private String insert_query = "INSERT INTO student_data (full_name,age,dob,phno,email,parents_name,address,blood_group,course_id) VALUES (?,?,?,?,?,?,?,?,?)";
	private String find_query = "SELECT * FROM student_data WHERE student_id=?";
	private String update_query = "UPDATE student_data SET  full_name=?, age=?,dob=?,phno=?,email=?,parents_name=?,address=?,blood_group=?,course_id=? WHERE student_id=?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override

	public int save(Student student) {
		return jdbcTemplate.update(insert_query, student.getFull_name(), student.getAge(), student.getDob(),
				student.getPhno(), student.getEmail(), student.getParents_name(), student.getAddress(),
				student.getBlood_group(), student.getCourse_id());
	}

	@Override
	public Student findbyId(int student_id) {
		return jdbcTemplate.queryForObject(find_query, BeanPropertyRowMapper.newInstance(Student.class), student_id);
	}

	@Override
	public int update(Student student) {
		return jdbcTemplate.update(update_query, student.getFull_name(), student.getAge(), student.getDob(),
				student.getPhno(), student.getEmail(), student.getParents_name(), student.getAddress(),
				student.getBlood_group(), student.getCourse_id(), student.getStudent_id());
	}
}
