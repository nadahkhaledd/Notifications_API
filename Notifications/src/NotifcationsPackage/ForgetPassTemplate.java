
package NotifcationsPackage;

import java.sql.PreparedStatement;

public class ForgetPassTemplate extends NotificationTemplate {

	public ForgetPassTemplate() {
		argumentsList.put("UserName", "X");
		argumentsList.put("ResetPass", "X");
		argumentsList.put("ID", "X");
	}

	public void getPlaceholders(String currentTemplate) {
		int counter = 1;
		for (int i = 0; i < currentTemplate.length(); i++) {
			String currentString = "";
			if (currentTemplate.charAt(i) == '$') {
				while (currentTemplate.charAt(i + 2) != '}') {
					currentString = currentString + currentTemplate.charAt(i + 2);
					i++;
				}
				if (counter == 1) {
					argumentsList.replace("UserName", currentString);
					counter++;
				} else if (counter == 2) {
					argumentsList.replace("ResetPass", currentString);
					counter++;
				} else if (counter == 3) {
					argumentsList.replace("ID", currentString);
					counter++;
				} else {
					break;
				}
			}
		}
	}

	public void create(String newTemplate) {
		getPlaceholders(newTemplate);
		try {
			DBConnection.initiateConnection();
			PreparedStatement myStmt = DBConnection.myConn.prepareStatement(
					"insert into forgetpasstemplate " + " (name, resetpass, id, template)" + " values (?, ?, ?, ?)");

			myStmt.setString(1, argumentsList.get("UserName"));
			myStmt.setString(2, argumentsList.get("ResetPass"));
			myStmt.setString(3, argumentsList.get("ID"));
			String temp = null;
			temp = newTemplate.replace("$", "");
			temp = temp.replace("{", "");
			temp = temp.replace("}", "");
			myStmt.setString(4, temp);

			myStmt.executeUpdate();
			System.out.println("Insert complete.");
		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

	
	public void update(String newTemplate) 
	{
		getPlaceholders(newTemplate);
		try {
			DBConnection.initiateConnection();
			PreparedStatement myStmt = DBConnection.myConn.prepareStatement("update forgetpasstemplate " + "set template = ?");
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
