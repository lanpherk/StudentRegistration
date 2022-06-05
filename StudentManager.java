//Katharine Lanpher
//Assignment 4
//CS T680-900
// This class builds an arraylist of students.

import java.util.Scanner;
import java.util.ArrayList;

class StudentManager
{
	private ArrayList<Student> studentList = new ArrayList<Student>();
	private StudentGateway studentG = new StudentGateway();
	

	public StudentManager(){
		studentList = studentG.findAll();

	}

	public ArrayList<Student> getStudentList(){
		return studentList;
	}


	public Student addStudent(String last, String first, String email, int sid){

		
		Student newStudent = new Student();
		newStudent.setlast(last);
		newStudent.setfirst(first);
		newStudent.setemail(email);
		newStudent.setsid(sid);
		
		studentList.add(newStudent);
		studentG.insert(last, first, email, sid);
		return newStudent;
		}

}

	

