package net.codejava;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class SMS {
	String content;
	int id;
	String target;
	
	public SMS()
	{
		
	}
	public SMS(String content, int id, String target) {
		super();
		this.content = content;
		this.id = id;
		this.target = target;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
}
