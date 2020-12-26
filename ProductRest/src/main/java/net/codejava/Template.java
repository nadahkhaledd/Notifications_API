package net.codejava;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Template {
	private String text;
	private int id;
	private String type;
	private String sec_type;

	public Template() {
	}

	public Template(String text, int id, String type) {
		super();
		this.text = text;
		this.id = id;
		this.type = type;
	}

	public String getTemplate() {
		return text;
	}

	public void setTemplate(String text) {
		this.text = text;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getSecType() {
		return sec_type;
	}

	public void setSecType(String sec_type) {
		this.sec_type = sec_type;
	}
}
