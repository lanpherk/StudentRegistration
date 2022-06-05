//Katharine Lanpher
//Assignment 4
//CS T680-900
//This class handles the database interaction for students

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


class ApplicationGateway {

	public ApplicationGateway(){

	}
	
	public ArrayList<Application> findAll(ArrayList<Student> studentList, ArrayList<Scholarship> scholarshipList){

		Connection conn = null;
		Statement stmt;
		ResultSet rs;
		String query;
		ArrayList<Application> applicationList = new ArrayList<Application>();
		Student astudent = null;
		Scholarship ascholarship = null;
	

	try{
		conn = DriverManager.getConnection("jdbc:sqlite:studentdb");
			System.out.println("Connection established");

			stmt = conn.createStatement();
			query = "SELECT AID, SID, CID FROM applications";

			rs = stmt.executeQuery(query);
			System.out.println("Queries executed");

		while(rs.next()){
			int aid = rs.getInt("aid");
			int sid = rs.getInt("sid");
				for( Student i : studentList){
					if (i.getsid() == sid){
					astudent = i;
					}
				}
			int cid = rs.getInt("cid");
				for( Scholarship i : scholarshipList){
					if (i.getid() == cid){
					ascholarship = i;
					}
				}
			Application newApplication = new Application(aid);
			newApplication.setstudent(astudent);
			newApplication.setscholarship(ascholarship);
			applicationList.add(newApplication);	
		}


		}
		catch(SQLException e){
			System.err.println(e.getMessage());
		}
		finally{
			try{
				if(conn != null)
					conn.close();
			}catch(SQLException e){
				System.err.println(e.getMessage());
			}
		}
		return applicationList;
	}


	public void insert(int aid, int sid, int cid){

		Connection conn = null;
		Statement stmt;
		ResultSet rs;
		String query;
	

	try{
		conn = DriverManager.getConnection("jdbc:sqlite:studentdb");

			query = "INSERT INTO applications VALUES (?,?,?)";

			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, aid);
			preparedStmt.setInt(2, sid);
			preparedStmt.setInt(3, cid);

			preparedStmt.execute();

		}
		catch(SQLException e){
			System.err.println(e.getMessage());
		}
		finally{
			try{
				if(conn != null)
					conn.close();
			}catch(SQLException e){
				System.err.println(e.getMessage());
			}
		}
	}

	public void delete(int aid){

		Connection conn = null;
		Statement stmt;
		ResultSet rs;
		String query;
	

	try{
		conn = DriverManager.getConnection("jdbc:sqlite:studentdb");

			query = "DELETE FROM applications WHERE aid = ?";

			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, aid);

			preparedStmt.execute();


		}
		catch(SQLException e){
			System.err.println(e.getMessage());
		}
		finally{
			try{
				if(conn != null)
					conn.close();
			}catch(SQLException e){
				System.err.println(e.getMessage());
			}
		}
	}




}

			
