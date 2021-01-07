package net.code.java;

public class Request {
	
	String[] values;
	String target;
	String method;
	
	public Request() {
		
	}
	
	public Request(String[] values, String target, String method) {
		super();
		this.values = values;
		this.target = target;
		this.method = method;
	}
	
	public String[] getValues() {
		return values;
	}
	
	public void setValues(String[] values) {
		this.values = values;
	}
	
	public String getTarget() {
		return target;
	}
	
	public void setTarget(String target) {
		this.target = target;
	}
	
	public String getMethod() {
		return method;
	}
	
	public void setMethod(String method) {
		this.method = method;
	}
}
