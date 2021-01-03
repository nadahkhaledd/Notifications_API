package net.codejava;

public class Notifications {
	private String content="";
	
	public Notifications()
	{
		
	}
	public Notifications(String content) {
		super();
		this.content = content;
	}
	
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Notification " + content + "]";
	}
}
