import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo
{

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt;
		ResultSet rs;
		String query;

		try{
			conn = DriverManager.getConnection("jdbc:sqlite:studentdb");
			System.out.println("Connection established");

			stmt = conn.createStatement();
			query = "SELECT LAST, FIRST, EMAIL FROM students";

			rs = stmt.executeQuery(query);
			System.out.println("Queries executed");

			while(rs.next()) {
				System.out.print(rs.getString("last") + ":" + rs.getString("first") + ":" + rs.getString("email")
					+ "\n");
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
	}
}