package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entity.Student;


public class StudentDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	//Save Student

	@Transactional
	public int insert(Student student) {

		// insert
		Integer i = (Integer) this.hibernateTemplate.save(student);

		return 1;
	}
	
	
	//get the single data(Object)
	public Student getStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}
	
	
	//get all rows	
	public List<Student> getallStudent(){
		List<Student> studntAll = this.hibernateTemplate.loadAll(Student.class);
		return studntAll;
	}
	
	//delete student data
	@Transactional
	public Student deleteStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class,studentId);
		this.hibernateTemplate.delete(student);
		
		return student;
		
	}
	
	
	//update student data
	@Transactional
	public void updateStudentData(Student student) {
		this.hibernateTemplate.update(student);
	}
	
	
}
