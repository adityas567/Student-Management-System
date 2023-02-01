package com.esspl.api.studentmanagement.dao;

import com.esspl.api.studentmanagement.model.Student;

public interface StudentRepository {

	int save(Student student);

	int update(Student student);
	
	Student findbyId(int student_id);
}
