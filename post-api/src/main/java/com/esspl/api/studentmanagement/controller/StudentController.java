package com.esspl.api.studentmanagement.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esspl.api.studentmanagement.dao.JdbcRepository;
import com.esspl.api.studentmanagement.model.Student;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	public JdbcRepository jdbcrepository;

	// Add Student
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/new")
	public ResponseEntity<Student> adduser(@RequestBody Student student) {

		try {
			jdbcrepository.save(student);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

	// update user
	@CrossOrigin(origins="http://localhost:4200")
	@PutMapping("/{student_id}")
	public ResponseEntity<Student> updateUser(@RequestBody Student student, @PathVariable int student_id) {
		Student prev_student = jdbcrepository.findbyId(student_id);
		try {

			if (prev_student != null) {
				prev_student.setFull_name(student.getFull_name());
				prev_student.setAge(student.getAge());
				prev_student.setDob(student.getDob());
				prev_student.setPhno(student.getPhno());
				prev_student.setEmail(student.getEmail());
				prev_student.setParents_name(student.getParents_name());
				prev_student.setAddress(student.getAddress());
				prev_student.setBlood_group(student.getBlood_group());
				prev_student.setCourse_id(student.getCourse_id());

			}

			jdbcrepository.update(prev_student);
			return ResponseEntity.of(Optional.of(prev_student));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

}
