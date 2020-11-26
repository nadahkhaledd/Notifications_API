package NotifcationsPackage;

import java.util.HashMap;

public class NotificationTemplate {

	Persistence behaviour;
	public static HashMap <String, String> argumentsList = new HashMap <String, String>();
	public NotificationTemplate () {
		argumentsList.put("Name", "X");
		argumentsList.put("Var", "X");
		argumentsList.put("ID", "X");
	}
	public static void getPlaceholders(String currentTemplate) {
		int counter = 1;
		for (int i = 0; i < currentTemplate.length(); i++) {
			String currentString = "";
			if (currentTemplate.charAt(i) == '$') {
				while (currentTemplate.charAt(i + 2) != '}') {
					currentString = currentString + currentTemplate.charAt(i + 2);
					i++;
				} 
				if (counter == 1) {
					argumentsList.replace("Name", currentString);
					counter++;
					
				} 
				else if (counter == 2) {
					argumentsList.replace("Var", currentString);
					counter++;
				} 
				else if (counter == 3) {
					argumentsList.replace("ID", currentString);
					counter++;
				} 
				else {
					break;
				}
			}
		}
	}
	
	public void setBehaviour(Persistence obj) {
		behaviour = obj;
	}
	
	public void Create(String currentTemplate) {
		behaviour.create(currentTemplate);
	}
	
	public void delete() {
		behaviour.delete();
	}
	
	public void read() {
		behaviour.read();
	}
	
	public void update(String currentTemplate) {
		behaviour.update(currentTemplate);
	}
}
