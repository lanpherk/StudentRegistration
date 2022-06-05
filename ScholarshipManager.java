//Katharine Lanpher
//Assignment 4
//CS T680-900
//This only does one thing and that is build the list of scholarships either by reading it with a ScholarshipReader or by taking it as a parameter from the Facade.


import java.util.ArrayList;

class ScholarshipManager
{
	private ArrayList<Scholarship> scholarshipList = new ArrayList<Scholarship>();
	private ScholarshipGateway scholarshipG = new ScholarshipGateway();

	//the constructor will build the list from the file when the object is created by the facade.
	public ScholarshipManager(){
		scholarshipList = scholarshipG.findAll();

	}

	//since the list is built in this class and many classes use it I made a method to get the list so it can be used by other classes. 
	public ArrayList<Scholarship> getScholarshipList(){
		return scholarshipList;
	}

	

	public Scholarship addScholarship(int id, String description, float amount){
		
		Scholarship newScholarship = new Scholarship();
		newScholarship.setid(id);
		newScholarship.setdescription(description);
		newScholarship.setamount(amount);
	
		scholarshipList.add(newScholarship);
		scholarshipG.insert(id, description, amount);
		return newScholarship;

	}
	

}