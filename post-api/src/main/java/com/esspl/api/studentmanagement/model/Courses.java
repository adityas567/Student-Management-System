package com.esspl.api.studentmanagement.model;

public class Courses {
	private int course_id;
	private String course_name;
	private String student_id;

	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Courses(int course_id, String course_name, String student_id) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.student_id = student_id;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	@Override
	public String toString() {
		return "Courses [course_id=" + course_id + ", course_name=" + course_name + ", student_id=" + student_id + "]";
	}

}
