package notificationOperations;

public class Notification {
	
	private String content;
	
	public Notification() {
		content = "";
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
}
