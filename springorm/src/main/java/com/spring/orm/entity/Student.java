package com.spring.orm.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

@Entity
@Table(name = "")
public class Student {

	@Id()
	@Column(name = "student_id")
	private int studentInt;

	@Column(name = "student_name")
	private String studentName;

	@Column(name = "student_city")
	private String studentCity;

	public int getStudentInt() {
		return studentInt;
	}

	public void setStudentInt(int studentInt) {
		this.studentInt = studentInt;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentCity() {
		return studentCity;
	}

	public void setStudentCity(String studentCity) {
		this.studentCity = studentCity;
	}

	public Student(int studentInt, String studentName, String studentCity) {
		super();
		this.studentInt = studentInt;
		this.studentName = studentName;
		this.studentCity = studentCity;
	}

	public Student() {

	}

}
