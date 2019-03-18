package com.jocker.controller;

public class Student {
	private String name;
	private String gender;
	private String school;
	private String fname;
	
	public Student() {
		
	}

	public Student(String name, String gender, String school, String fname) {
		this.name = name;
		this.gender = gender;
		this.school = school;
		this.fname = fname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", gender=" + gender + ", school=" + school + ", fname=" + fname + "]";
	}

}
