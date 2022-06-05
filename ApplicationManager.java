//Katharine Lanpher
//Assignment 4
//CS T680-900
//This only does one thing and that is build the list of scholarships from the database or entered. This method can also delete a scholarship.


import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;

class ApplicationManager
{
	private ArrayList<Application> applicationList = new ArrayList<Application>();
	private ApplicationGateway applicationG = new ApplicationGateway();


	//the constructor will build the list from the file when the object is created by the facade.
	public ApplicationManager(){	

	}

	//since the list is built in this class and many classes use it I made a method to get the list so it can be used by other classes. 
	public ArrayList<Application> getApplicationList(){
		return applicationList;
	}

	public void setApplicationList(ArrayList<Application> applicationList){
		this.applicationList = applicationList;
	}

	

	public void addApplication(Student astudent, Scholarship ascholarship){

		int aid = applicationList.size() + 1;
		
		//check if the id is already taken and change if necessary
		for(Application i : applicationList){
			int temp = i.getaid();
			if(temp == aid){
				int newaid = findHighest();
				aid = newaid + 1;
			}
		}
		Application newApplication = new Application(aid);
	
		newApplication.setstudent(astudent);
		newApplication.setscholarship(ascholarship);
	
		applicationList.add(newApplication);
		applicationG.insert(aid, newApplication.getsid(), newApplication.getcid());
		System.out.println(newApplication.toString());
		

	}

	public void deleteApplication(){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the Scholarship id you wish to delete.");
		int aid = input.nextInt();
		boolean found = false;
		Application foundApp = null;

		for(Application i : applicationList){
			int temp = i.getaid();
			if(temp == aid){
				foundApp = i;
				found = true;
			}

		}
		if (found == true){
			applicationList.remove(foundApp);
			applicationG.delete(foundApp.getaid());
			System.out.println("DELETED: " + foundApp.toString());
		}

		if(found == false){
			System.out.println("Scholarship " + aid + " not found.");
		}


	}
	//this method is in case the number of the application is already taken
	private int findHighest(){
		int high = 0;
		for(Application i : applicationList){
			if(i.getaid() > high){
				high = i.getaid();
			}
		}
		return high;
					
	}
	

}