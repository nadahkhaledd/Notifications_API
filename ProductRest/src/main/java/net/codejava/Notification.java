package net.codejava;

public class Notification {
	private String content="";
	
	public Notification()
	{
		
	}
	public Notification(String content) {
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
		return "Notification [content=" + content + "]";
	}
}
