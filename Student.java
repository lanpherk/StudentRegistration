//Katharine Lanpher
//Assignment 4
//CS T680-900
//This class handles student information.

class Student
{
	private String first;
	private String last;
	private String email;
	private int sid;

	public Student(){
		this.first = first;
		this.last = last;
		this.email = email;
		this.sid = sid;
	}

	public String getfirst() {
		return first;
	}
	public void setfirst(String first){
		this.first = first;
	}

	public String getlast() {
		return last;
	}
	public void setlast(String last){
		this.last = last;
	}

	public String getemail() {
		return email;
	}
	public void setemail(String email){
		this.email = email;
	}

	public int getsid() {
		return sid;
	}
	public void setsid(int sid){
		this.sid = sid;
	}

	public String toString(){
		String student = last + "," + first + "," + email + "," + sid;
		return student;

	}

}