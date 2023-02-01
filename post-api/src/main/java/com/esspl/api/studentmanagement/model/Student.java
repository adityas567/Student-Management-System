package com.esspl.api.studentmanagement.model;

public class Student {

	private int student_id;
	private String full_name;
	private int age;
	private String dob;
	private String phno;
	private String email;
	private String parents_name;
	private String address;
	private String blood_group;
	private int course_id;

	public Student() {
		super();
		
	}

	public Student(int student_id, String full_name, int age, String dob, String phno, String email, String parents_name,
			String address, String blood_group, int course_id) {
		super();
		this.student_id = student_id;
		this.full_name = full_name;
		this.age = age;
		this.dob = dob;
		this.phno = phno;
		this.email = email;
		this.parents_name = parents_name;
		this.address = address;
		this.blood_group = blood_group;
		this.course_id = course_id;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getParents_name() {
		return parents_name;
	}

	public void setParents_name(String parents_name) {
		this.parents_name = parents_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBlood_group() {
		return blood_group;
	}

	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", full_name=" + full_name + ", age=" + age + ", dob=" + dob
				+ ", phno=" + phno + ", email=" + email + ", parents_name=" + parents_name + ", address=" + address
				+ ", blood_group=" + blood_group + ", course_id=" + course_id + "]";
	}

}