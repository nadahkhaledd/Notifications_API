package NotifcationsPackage;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;



public class DatabaseOperations implements Persistence {
	DatabaseOperations() {
		DBConnection.initiateConnection();
	}
	
	public boolean idExists(String ID) {
		try {
			PreparedStatement checkStmt = DBConnection.myConn.prepareStatement("SELECT template FROM templatetable WHERE id=? ");
			checkStmt.setString(1, ID);
			ResultSet myRs = checkStmt.executeQuery();
			if (myRs.next()) {
				return true;
			}
			else {
				return false;
			}
		}
		catch (Exception exc) {
            exc.printStackTrace();
            return true;
        }
	}
	
	@Override
	public void create(String newTemplate) {
		NotificationTemplate.getPlaceholders(newTemplate);
		if(!idExists(NotificationTemplate.argumentsList.get("ID"))) {
			Scanner input = new Scanner(System.in);
			System.out.println("Enter the type of the template");
			String type = input.nextLine();
			input.close();
			try {
				PreparedStatement myStmt = DBConnection.myConn.prepareStatement("insert into templatetable " + " (name, var, id, type, template)"
		                + " values (?, ?, ?, ?, ?)");
				myStmt.setString(1, NotificationTemplate.argumentsList.get("Name"));
				myStmt.setString(2, NotificationTemplate.argumentsList.get("Var"));
				myStmt.setString(3, NotificationTemplate.argumentsList.get("ID"));
				myStmt.setString(4, type);
				String temp = null;
				temp = newTemplate.replace("$", "");
				temp = temp.replace("{", "");
				temp = temp.replace("}", "");
				myStmt.setString(5, temp);
				myStmt.executeUpdate();
		        System.out.println("Insert complete.");
			}
			catch (Exception exc) {
	            exc.printStackTrace();
	        }
		}
		else {
			System.out.println("ID already exists.");
		}
	}

	@Override
	public void delete() {
		try {
			Scanner input = new Scanner(System.in);
			System.out.println("Enter ID");
			String ID = input.nextLine();
			input.close();
			if(idExists(ID)) {
				PreparedStatement myStmt = DBConnection.myConn.prepareStatement("delete from templatetable"+" where id = ?");
				myStmt.setString(1, ID);
				myStmt.executeUpdate();
		        System.out.println("delete complete");
			}
			else {
				System.out.println("ID not found");
			}
		}
		catch (Exception exc) {
            exc.printStackTrace();
        }
		
	}

	@Override
	public void read() 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter ID");
		String id = input.nextLine();
		input.close();
		if(idExists(id)) { 
			try {
				PreparedStatement st = DBConnection.myConn.prepareStatement("SELECT template FROM templatetable WHERE id= ?");
				st.setString(1, id);
				var rs = st.executeQuery();
				rs.next();
				String template = rs.getString("template");
				System.out.println(template);
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else { 
			System.out.println("ID not found");
		}
		
	}

	@Override
	public void update(String newTemplate) 
	{
		NotificationTemplate.getPlaceholders(newTemplate);
		Scanner input = new Scanner(System.in);
		System.out.println("ID ?");
		String id = input.nextLine();
		input.close();
		if(idExists(id)) { 
			try {
				PreparedStatement myStmt = DBConnection.myConn.prepareStatement("update templatetable " + "set template = ? where id=?");
				String temp = null;
				temp = newTemplate.replace("$", "");
				temp = temp.replace("{", "");
				temp = temp.replace("}", "");
				myStmt.setString(1, temp);
				myStmt.setString(2, id);
				myStmt.executeUpdate();
		        System.out.println("update complete.");
			}
			catch (Exception exc) {
	            exc.printStackTrace();
	        }
		}
		else {
			System.out.println("ID not found");
		}

	}

}
