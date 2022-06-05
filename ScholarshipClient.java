//Katharine Lanpher
//Assignment 4
//CS T680-900

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

class ScholarshipClient
{


		public static void main(String[] args)
		{
			ScholarshipSystemFacade newS = new ScholarshipSystemFacade();
			int choiceNo = 0;
			Scanner input = new Scanner(System.in);
			while(choiceNo != 10){
			
			System.out.println();
			System.out.println("Enter your choice number from the list below:");
			System.out.println("1. Enter a new student.");
			System.out.println("2. Display a list of students.");
			System.out.println("3. Enter a new scholarship.");
			System.out.println("4. Display a list of scholarships.");
			System.out.println("5. Edit or delete a student");
			System.out.println("6. Edit or delete a scholarship");
			System.out.println("7. Enter an application");
			System.out.println("8. Display all applications");
			System.out.println("9. Delete an application");
			System.out.println("10. Exit");

			choiceNo = input.nextInt();

			

			if (choiceNo == 1){
				newS.enterNewStudent();
			}

			if (choiceNo == 2){
				newS.displayAllStudents();
			}

			if (choiceNo == 3){
				newS.enterNewScholarship();
			}

			if (choiceNo == 4){
				newS.displayAllScholarships();
			}

			if (choiceNo == 5){
				newS.changeStudent();
			}
			if (choiceNo == 6){
				newS.changeScholarship();
			}
			if (choiceNo == 7){
				newS.enterNewApplication();
			}
			if (choiceNo == 8){
				newS.displayAllApplications();
			}
			if (choiceNo == 9){
				newS.changeApplication();
			}

		}
		
		}


}