package com.esspl.api.studentmanagement.model;

public class Subject {
	private int sub_id;
	private String sub_name;
	private String course_id;

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subject(int sub_id, String sub_name, String course_id) {
		super();
		this.sub_id = sub_id;
		this.sub_name = sub_name;
		this.course_id = course_id;
	}

	public int getSub_id() {
		return sub_id;
	}

	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}

	public String getSub_name() {
		return sub_name;
	}

	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	@Override
	public String toString() {
		return "Subject [sub_id=" + sub_id + ", sub_name=" + sub_name + ", course_id=" + course_id + "]";
	}

}
