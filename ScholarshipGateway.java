
//Katharine Lanpher
//Assignment 4
//CS T680-900
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


class ScholarshipGateway {

	public ScholarshipGateway(){

	}
	
	public ArrayList<Scholarship> findAll(){

		Connection conn = null;
		Statement stmt;
		ResultSet rs;
		String query;
		ArrayList<Scholarship> scholarshipList = new ArrayList<Scholarship>();
	

	try{
		conn = DriverManager.getConnection("jdbc:sqlite:studentdb");
			System.out.println("Connection established");

			stmt = conn.createStatement();
			query = "SELECT CID, DESCRIPTION, AMOUNT FROM scholarships";

			rs = stmt.executeQuery(query);
			System.out.println("Queries executed");

		while(rs.next()){
			int cid = rs.getInt("cid");
			String description = rs.getString("description");
			float amount = rs.getFloat("amount");

			Scholarship newScholarship = new Scholarship();
			newScholarship.setid(cid);
			newScholarship.setdescription(description);
			newScholarship.setamount(amount);
			
			scholarshipList.add(newScholarship);
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
		return scholarshipList;
	}

	public void update(int cid, String description, float amount){

		Connection conn = null;
		Statement stmt;
		ResultSet rs;
		String query;
	

	try{
		conn = DriverManager.getConnection("jdbc:sqlite:studentdb");
			System.out.println("Connection established");

			query = "UPDATE scholarships SET description = ?, " + "amount = ? " + "WHERE cid = ?";

			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, description);
			preparedStmt.setFloat(2, amount);
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

	public void insert(int cid, String description, float amount){

		Connection conn = null;
		Statement stmt;
		ResultSet rs;
		String query;
	

	try{
		conn = DriverManager.getConnection("jdbc:sqlite:studentdb");

			query = "INSERT INTO scholarships VALUES (?,?,?)";

			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, cid);
			preparedStmt.setString(2, description);
			preparedStmt.setFloat(3, amount);

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

	public void delete(int cid){

		Connection conn = null;
		Statement stmt;
		ResultSet rs;
		String query;
	

	try{
		conn = DriverManager.getConnection("jdbc:sqlite:studentdb");

			query = "DELETE FROM scholarships WHERE cid = ?";

			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, cid);

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
