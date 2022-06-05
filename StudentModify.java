//Katharine Lanpher
//Assignment 4
//CS T680-900
//This class deletes or changes student information.

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

class StudentModify
{
	private StudentGateway studentG = new StudentGateway();

	public StudentModify(){
		

	}

	public void modifyStudent(ArrayList<Student> studentList){
		
	int no = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("What is the student id of the student you wish to change or delete?");
		int sid = input.nextInt();
		
		Student sfound = findStudent(sid, studentList);
		System.out.println("The student found was " + sfound.toString() + " if this is incorrect enter 1, if it is correct enter 2.");
		int oops = input.nextInt();
		if (oops == 1){
			System.out.println("Try again from the main menu.");
			return;
		}

		String first = sfound.getfirst();
		String last = sfound.getlast();
		String email = sfound.getemail();

		while (no != 5){
			System.out.println("Type the number of your choice for student " + sfound.toString());
			System.out.println("1. Delete this student");
			System.out.println("2. Change the student first name");
			System.out.println("3. Change the student last name");
			System.out.println("4. Change the student email");
			System.out.println("5. Save and exit");
			no = input.nextInt();
			if (no == 1){
				removeStudent(sfound, studentList);
				studentG.delete(sid);
				
				return;
			}

			if (no == 2){
				System.out.println("What is the new first name?");
				String newFirst = input.next();
				sfound.setfirst(newFirst);
				System.out.println("The student has been changed to " + sfound.toString());
				studentG.update(last, newFirst, email, sid);
			}

			if (no == 3){
				System.out.println("What is the new last name?");
				String newLast = input.next();
				sfound.setlast(newLast);
				System.out.println("The student has been changed to " + sfound.toString());
				studentG.update(newLast, first, email, sid);
			}
			if (no == 4){
				System.out.println("What is the new email address?");
				String newemail = input.next();
				sfound.setemail(newemail);
				System.out.println("The student has been changed to " + sfound.toString());
				studentG.update(last, first, newemail, sid);
			}


			if (no == 5){
				
			}


		}
	}

	private Student findStudent(int sid, ArrayList<Student> studentList){
		Student found = studentList.get(0);

		for(Student i : studentList){
			int x = i.getsid();

			if(x == sid){
				found = i;
			}
		}
	return found;

	}

	private void removeStudent(Student sfound, ArrayList<Student> studentList){
		studentList.remove(sfound);
		System.out.println(sfound.toString() + " has been removed.");

	}

}