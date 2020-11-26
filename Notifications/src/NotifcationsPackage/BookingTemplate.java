package NotifcationsPackage;

import java.sql.PreparedStatement;

public class BookingTemplate extends NotificationTemplate {
	public BookingTemplate () {
		argumentsList.put("Name", "X");
		argumentsList.put("Item", "X");
		argumentsList.put("ID", "X");
	}
	
	public void getPlaceholders(String currentTemplate) {
		int counter = 1;
		for(int i = 0; i < currentTemplate.length(); i++) {
			String currentString = "";
			if(currentTemplate.charAt(i) == '$') {
				while(currentTemplate.charAt(i+2) != '}') {
					currentString = currentString + currentTemplate.charAt(i+2);
					i++;
				}
				if(counter == 1) {
					argumentsList.replace("Name", currentString);
					counter++;
				}
				else if(counter == 2) {
					argumentsList.replace("Item", currentString);
					counter++;
				}
				else if(counter == 3)
				{
					argumentsList.replace("ID", currentString);
					counter++;
				}
				else {
					break;
				}
			}
		}
	}
	
	public void create(String newTemplate) {
		getPlaceholders(newTemplate);
		try {
			DBConnection.initiateConnection();
			PreparedStatement myStmt = DBConnection.myConn.prepareStatement("insert into bookingtemplate " + " (name, item, id, template)"
	                + " values (?, ?, ?, ?)");
			
			myStmt.setString(1, argumentsList.get("Name"));
			myStmt.setString(2, argumentsList.get("Item"));
			myStmt.setString(3, argumentsList.get("ID"));
			String temp = null;
			temp = newTemplate.replace("$", "");
			temp = temp.replace("{", "");
			temp = temp.replace("}", "");
			myStmt.setString(4, temp);
			
			myStmt.executeUpdate();
	        System.out.println("Insert complete.");
		}
		catch (Exception exc) {
            exc.printStackTrace();
        } 
		
	}
	
	public void update(String newTemplate) 
	{
		getPlaceholders(newTemplate);
		try {
			DBConnection.initiateConnection();
			PreparedStatement myStmt = DBConnection.myConn.prepareStatement("update bookingtemplate " + "set template = ?");
			String temp = null;
			temp = newTemplate.replace("$", "");
			temp = temp.replace("{", "");
			temp = temp.replace("}", "");
			myStmt.setString(1, temp);
			myStmt.executeUpdate();
	        System.out.println("update complete.");
		}
		catch (Exception exc) {
            exc.printStackTrace();
        }
	}
	public void delete() {}
}
