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


class StudentGateway {

	public StudentGateway(){

	}
	
	public ArrayList<Student> findAll(){

		Connection conn = null;
		Statement stmt;
		ResultSet rs;
		String query;
		ArrayList<Student> studentList = new ArrayList<Student>();
	

	try{
		conn = DriverManager.getConnection("jdbc:sqlite:studentdb");
			System.out.println("Connection established");

			stmt = conn.createStatement();
			query = "SELECT LAST, FIRST, EMAIL, SID FROM students";

			rs = stmt.executeQuery(query);
			System.out.println("Queries executed");

		while(rs.next()){
			String last = rs.getString("last");
			String first = rs.getString("first");
			String email = rs.getString("email");
			int sid = rs.getInt("sid");

			Student newStudent = new Student();
			newStudent.setlast(last);
			newStudent.setfirst(first);
			newStudent.setemail(email);
			newStudent.setsid(sid);
			studentList.add(newStudent);
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
		return studentList;
	}

	public void update(String last, String first, String email, int sid){

		Connection conn = null;
		Statement stmt;
		ResultSet rs;
		String query;
	

	try{
		conn = DriverManager.getConnection("jdbc:sqlite:studentdb");
			System.out.println("Connection established");

			query = "UPDATE students SET last= ?, " + "first = ?," + "email = ? " + "WHERE sid = ?";

			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, last);
			preparedStmt.setString(2, first);
			preparedStmt.setString(3, email);
			preparedStmt.setInt(4, sid);

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

	public void insert(String last, String first, String email, int sid){

		Connection conn = null;
		Statement stmt;
		ResultSet rs;
		String query;
	

	try{
		conn = DriverManager.getConnection("jdbc:sqlite:studentdb");

			query = "INSERT INTO students VALUES (?,?,?,?)";

			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, last);
			preparedStmt.setString(2, first);
			preparedStmt.setString(3, email);
			preparedStmt.setInt(4, sid);

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

	public void delete(int sid){

		Connection conn = null;
		Statement stmt;
		ResultSet rs;
		String query;
	

	try{
		conn = DriverManager.getConnection("jdbc:sqlite:studentdb");

			query = "DELETE FROM students WHERE sid = ?";

			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, sid);

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

			





