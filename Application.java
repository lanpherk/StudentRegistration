//Katharine Lanpher
//Assignment 4
//CS T680-900
//This class handles application information.

class Application
{
	private int aid;
	private Student astudent;
	private Scholarship ascholarship;

	public Application(int aid){
		this.aid = aid;
	}

	public int getaid() {
		return aid;
	}
	public void setaid(int aid){
		this.aid = aid;
	}

	public Student getstudent() {
		return astudent;
	}
	public void setstudent(Student astudent){
		this.astudent = astudent;
	}

	public Scholarship getscholarship() {
		return ascholarship;
	}
	public void setscholarship(Scholarship ascholarship){
		this.ascholarship = ascholarship;
	}

	public int getsid(){
		return astudent.getsid();
	}

	public int getcid(){
		return ascholarship.getid();
	}

	
	public String toString(){
		String applicationstring = "APPLICATION NUMBER : " + aid + " STUDENT : " + astudent.toString() + " SCHOLARSHIP : " + ascholarship.toString();
		return applicationstring;

	}

}