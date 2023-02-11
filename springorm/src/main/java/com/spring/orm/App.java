package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entity.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/orm/springOrmConfig.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
		Student student = new Student();

//       Student student=new Student(2324,"Pandurang Shinde","Nashik");
//       
//       int r = studentDao.insert(student);
//       System.out.println(r);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean go = true;

		while (go) {
			System.out.println("PRESS 1 for add new student");
			System.out.println("PRESS 2 for display all student");
			System.out.println("PRESS 3 for get details of single student");
			System.out.println("PRESS 4 for delete students");
			System.out.println("PRESS 5 for update students");
			System.out.println("PRESS 6 for exit");
			System.out.println();

			try {
				int input = Integer.parseInt(br.readLine());

//			if(input==1) {
//				//add a new student
//			}else if(input==2) {
//				//display
//			}

				switch (input) {
				case 1:
					// add a new student
					// taking input form user
					System.out.println("Enter student id : ");
					int uId = Integer.parseInt(br.readLine());

					System.out.println("Enter student name :");
					String uName = br.readLine();

					System.out.println("Enter student city");
					String uCity = br.readLine();

					// creating student object and setting values
					student.setStudentId(uId);
					student.setStudentName(uName);
					student.setStudentCity(uCity);

					// aving student object to database by calling insert of student dao
					int i = studentDao.insert(student);
					System.out.println(i + "  Student added");
					System.out.println("***************************************************************");
					System.out.println();

					break;
				case 2:
					// display all student
					System.out.println("***************************************************************");
					List<Student> getallStudent = studentDao.getallStudent();
					for (Student student2 : getallStudent) {
						System.out.println("ID : " + student2.getStudentId());
						System.out.println("Name : " + student2.getStudentName());
						System.out.println("City :" + student2.getStudentCity());
						System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
					}
					System.out.println("***************************************************************");

					break;
				case 3:
					// get single student data
					System.out.println("Enter Student Id if we want : ");
					int studentID = Integer.parseInt(br.readLine());

					Student student2 = studentDao.getStudent(studentID);
					System.out.println("ID : " + student2.getStudentId());
					System.out.println("Name : " + student2.getStudentName());
					System.out.println("City :" + student2.getStudentCity());
					System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");

					break;
				case 4:
					// delete student
					System.out.println("Enter Student ID If we want to delete");
					int id = Integer.parseInt(br.readLine());
					Student deleteStudent = studentDao.deleteStudent(id);

					System.out.println("ID : " + deleteStudent.getStudentId());
					System.out.println("Name : " + deleteStudent.getStudentName());
					System.out.println("City :" + deleteStudent.getStudentCity());
					System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");

					break;
				case 5:
					// update student
					System.out.println("Enter the Id we want to update data");
					int studentI = Integer.parseInt(br.readLine());

					Student student3 = studentDao.getStudent(studentI);

					// set data from using id update
					System.out.println("Enter student name :");
					String uname = br.readLine();

					System.out.println("Enter student city");
					String ucity = br.readLine();

					student3.setStudentName(uname);
					student3.setStudentCity(ucity);

					studentDao.updateStudentData(student3);

					break;
				case 6:
					// exit
					go = false;
					break;

				default:
					break;
				}

			} catch (Exception e) {
				System.out.println("Invalid Input Try with another one !!");
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Thanks for using my applications");

	}
}
