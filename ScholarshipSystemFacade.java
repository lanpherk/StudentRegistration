//Katharine Lanpher
//Assignment 4
//CS T680-900
//This class directs the program to manipulate students and scholarships.

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

class ScholarshipSystemFacade
{
	private StudentManager newManager = new StudentManager();
	private StudentModify newStModify = new StudentModify();
	private ScholarshipManager newSManager = new ScholarshipManager();
	private ScholarshipModify newScModify = new ScholarshipModify();
	private DisplayList newDisplay = new DisplayList();
	private ApplicationManager newAManager = new ApplicationManager();
	private ApplicationGateway applicationG = new ApplicationGateway();
		
	

	public ScholarshipSystemFacade(){
		ArrayList<Student> studentList = newManager.getStudentList();
		ArrayList<Scholarship> scholarshipList = newSManager.getScholarshipList();
		ArrayList<Application> applicationList = applicationG.findAll(studentList, scholarshipList);
		newAManager.setApplicationList(applicationList);

	}


	public void displayAllStudents(){
		ArrayList<Student> studentList = newManager.getStudentList();
		newDisplay.displayStudentList(studentList);

	}

	public void enterNewStudent(){
		Scanner input = new Scanner(System.in);
		
		System.out.println("What is the last name of the student?");
		String last = input.next();
		System.out.println("What is the first name of the student?");
		String first = input.next();
		System.out.println("What is the email of the student?");
		String email = input.next();
		System.out.println("What is the id number of the student?");
		int sid = input.nextInt();

		ArrayList<Student> studentList = newManager.getStudentList();

		for(Student i : studentList){
			int x = i.getsid();

			if(x == sid){
				System.out.println("A STUDENT WITH THE ID " + sid + " ALREADY EXISTS IN THE SYSTEM PLEASE TRY AGAIN.");
				return;
			}
		}
		//take input add it and then print the new record to the file.
		Student newStudent = newManager.addStudent(last, first, email, sid);
		System.out.println("Student " + first + " " + last + " added.");
		

	}

	//The implementation of these methods was hidden by creating a new class. This class simply passes the information it needs. 
	public void changeStudent(){
		ArrayList<Student> studentList = newManager.getStudentList();
		newStModify.modifyStudent(studentList);
	}

	public void displayAllScholarships(){
		ArrayList<Scholarship> scholarshipList = newSManager.getScholarshipList();
		newDisplay.displayScholarshipList(scholarshipList);

	}

	public void enterNewScholarship(){
		ArrayList<Scholarship> scholarshipList = newSManager.getScholarshipList();

		Scanner input = new Scanner(System.in).useDelimiter("\\n");
		System.out.println("What is id of the scholarship?");
		int id = input.nextInt();
		//check if that id already exists.
		for(Scholarship i : scholarshipList){
			int n = i.getid();
			
			if(n == id){
			System.out.println("THE ID " + id + " IS ALREADY IN USE PLEASE TRY AGAIN");
			return;
			}
		}


		System.out.println("What is the description of the scholarship?");
		String description = input.next();
		System.out.println("What is the amount of the scholarship?");
		float amount = input.nextFloat();

		Scholarship newScholarship = newSManager.addScholarship(id, description, amount);

	}

	public void changeScholarship(){
		ArrayList<Scholarship> scholarshipList = newSManager.getScholarshipList();
		newScModify.modifyScholarship(scholarshipList);
		}

	public void enterNewApplication(){
		ArrayList<Application> applicationList = newAManager.getApplicationList();
		ArrayList<Student> studentList = newManager.getStudentList();
		ArrayList<Scholarship> scholarshipList = newSManager.getScholarshipList();
		Student astudent = null;
		Scholarship ascholarship = null;

		Scanner input = new Scanner(System.in).useDelimiter("\\n");
		System.out.println("What is id number of the student applying for a scholarship?");
		int sid = input.nextInt();

		for(Student i : studentList){
			int n = i.getsid();
			
			if(n == sid){
			astudent = i;
			}
		}
		if (astudent == null) {
				System.out.println("Student " + sid + " not found.");
				return;
			}

		System.out.println("What is id number of the scholarship the student wants to apply for?");
		int cid = input.nextInt();
		//find the scholarship
		for(Scholarship i : scholarshipList){
			int n = i.getid();
			
			if(n == cid){
			ascholarship = i;
			}
		}
		if(ascholarship == null) {
				System.out.println("Scholarship " + cid + " not found.");
				return;
			}


		newAManager.addApplication(astudent, ascholarship);

	}

	public void displayAllApplications(){
		ArrayList<Application> applicationList = newAManager.getApplicationList();
		newDisplay.displayApplicationList(applicationList);

	}

	public void changeApplication(){
		newAManager.deleteApplication();
	}
		
}
