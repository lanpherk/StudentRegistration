//Katharine Lanpher
//Assignment 3
//CS T680-900
//This class handles scholarship information

class Scholarship
{
	private int id;
	private String description;
	private float amount;

	public Scholarship(){
		this.id = id;
		this.description = description;
		this.amount = amount;
	}

	public int getid() {
		return id;
	}
	public void setid(int id){
		this.id = id;
	}

	public String getdescription() {
		return description;
	}
	public void setdescription(String description){
		this.description = description;
	}

	public float getamount() {
		return amount;
	}
	public void setamount(float amount){
		this.amount = amount;
	}


	public String toString(){
		String scholarship = id + "," + description + "," + amount;
		return scholarship;

	}

}