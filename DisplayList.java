//Katharine Lanpher
//Assignment 4
//CS T680-900

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

class DisplayList
{
	public DisplayList(){

	}

	public void displayScholarshipList(ArrayList<Scholarship> scholarshipList){

		for(Scholarship i : scholarshipList){
			String sch = i.toString();
			System.out.println(sch);
		}

	}

	public void displayStudentList(ArrayList<Student> studentList){

		for(Student i : studentList){
			String stud = i.toString();
			System.out.println(stud);
		}

	}

	public void displayApplicationList(ArrayList<Application> applicationList){

		for(Application i : applicationList){
			String app = i.toString();
			System.out.println(app);
		}

	}



}