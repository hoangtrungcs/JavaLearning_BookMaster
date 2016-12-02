package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Enums;

public class DBConnection {
	
	  static final String JDBC_DRIVER = "org.postgresql.Driver"; 
	  static final String DB_URL = "jdbc:postgresql://localhost:5432/BookMaster";
	  static final String USER = "postgres"; static
	  final String PASS = "abc123";

	public static Connection conn = null;
	Statement stmt = null;

	public DBConnection() {
		try {
			Class.forName(JDBC_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;
		}
	}

	//Open connection
	public boolean OpenConnection() {
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException ex) {
			return false;
		}
		return true;
	}

	//Execute sql query
	public ResultSet GetData(String stringSql) {
		ResultSet result = null;
		try {
			Statement lenh = this.conn.createStatement();
			result = lenh.executeQuery(stringSql);
		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return result;
	}

	//Excute sql query to update, in sert, delete
	public int ExcuteUpdate(String str) {
		try {
			Statement lenh = this.conn.createStatement();
			int result = lenh.executeUpdate(str);
			
			System.out.println("test excute" + result);
			if(result!=0)
				return 1;//successfull
			else
				return -1;//fail
		} catch (SQLException ex) {
			return  Enums.ErrorsManage.DB_ERROR.getErrorNumber();
		}
	}

	//Close connection
	public void CloseConnection() {
		if (this.conn != null) {
			try {
				this.conn.close();
			} catch (SQLException ex) {
				System.out.println(ex);
			}
		}
	}
}
