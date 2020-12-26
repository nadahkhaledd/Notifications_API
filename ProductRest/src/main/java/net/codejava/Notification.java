package net.codejava;

import java.util.LinkedList;
import java.util.Queue;

public class Notification {
	private static String content="";
	
	public Notification()
	{
		
	}
	public Notification(String content, int id) {
		super();
		Notification.content = content;
	}
	
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		Notification.content = content;
	}
	
	public void prepareNotification(String msg) {
		String [] values = {"hussien", "mobile"};
		int index = 0;
		int i = 0;
		while(true) {
			if(msg.indexOf("$", index) == -1) {
				break;
			}
			String temp = msg.substring(msg.indexOf("$", index), msg.indexOf("}", index)+1);
			index = msg.indexOf("}", index)+1;
			msg = msg.replace(temp, values[i]);
			i++;
		}
		setContent(msg);
	}
	
	
	
	

}
