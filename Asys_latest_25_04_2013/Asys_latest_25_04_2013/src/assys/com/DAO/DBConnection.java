/**
 * 
 */
package assys.com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author nirav
 */

public class DBConnection {

	private static String userName = "root";
	private static String passWord = "root";
	private static String url = "jdbc:mysql://localhost:3306/assys";
	private static String driverClassName = "com.mysql.jdbc.Driver";

	public static Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, userName, passWord);
			if (conn == null) {
				System.out.println("Could Not Connected To DataBase");
			} else {
				System.out.println("Connected Successfully");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
