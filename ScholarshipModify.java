//Katharine Lanpher
//Assignment 3
//CS T680-900
//This class deletes or changes scholarship information.

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

class ScholarshipModify
{
	private ScholarshipGateway scholarshipG = new ScholarshipGateway();

	public ScholarshipModify(){
		

	}

	public void modifyScholarship(ArrayList<Scholarship> scholarshipList){
		int no = 0;
		Scanner input = new Scanner(System.in).useDelimiter("\\n");
		System.out.println("What is the id number of the scholarship you wish to change or delete?");
		int id = input.nextInt();
		Scholarship scfound = findScholarship(id, scholarshipList);
		System.out.println("The scholarship found was ( " + scfound.toString() + " ) if this is incorrect enter 1, if it is correct enter 2.");
		int oops = input.nextInt();
		if (oops == 1){
			System.out.println("Try again from the main menu.");
			return;
		}

		String description = scfound.getdescription();
		float amount = scfound.getamount();

		while (no != 4){
			System.out.println("Type the number of your choice for scholarship " + scfound.getid());
			System.out.println("1. Delete this scholarship");
			System.out.println("2. Change the scholarship description");
			System.out.println("3. Change the scholarship amount");
			System.out.println("4. Save and exit");
			no = input.nextInt();
			if (no == 1){
				removeScholarship(scfound, scholarshipList);
				scholarshipG.delete(id);
				return;
			}

			if (no == 2){
				System.out.println("What is the new description?");
				String newDesc = input.next();
				scfound.setdescription(newDesc);
				scholarshipG.update(id, newDesc, amount);
				System.out.println("The scholarship has been changed to " + scfound.toString());
			}

			if (no == 3){
				System.out.println("What is the new amount?");
				float newamount = input.nextFloat();
				scfound.setamount(newamount);
				scholarshipG.update(id, description, newamount);
				System.out.println("The scholarship has been changed to " + scfound.toString());
			}


			if (no == 4){
			
			}
		}


	}

	private Scholarship findScholarship(int id, ArrayList<Scholarship> scholarshipList){
		Scholarship found = scholarshipList.get(0);

		for(Scholarship i : scholarshipList){
			int n = i.getid();

			if(n == id){
				found = i;
			}
		}
	return found;

	}

	private void removeScholarship(Scholarship scfound, ArrayList<Scholarship> scholarshipList){
		scholarshipList.remove(scfound);
		System.out.println(scfound.toString() + " has been removed.");

	}
}
		