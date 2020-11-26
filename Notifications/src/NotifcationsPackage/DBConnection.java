package NotifcationsPackage;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	static Connection myConn = null;

	 public static void initiateConnection()
	 {
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/templates", "root" , "0000");
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
