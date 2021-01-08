package net.code.java;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

public class DequeueMAIL implements DequeueStrategy {
	
	private static final String GET_FIRST_ID_MAIL = "http://localhost:8080/templates6/";
	private static final String DELETE_MAIL = "http://localhost:8080/templates4/{id}";
	static RestTemplate restTemplate = new RestTemplate();
	
	public String dequeue() {
		try {
			MAIL obj = restTemplate.getForObject(GET_FIRST_ID_MAIL, MAIL.class);
			String output = "Notification: [" + obj.getContent() + "] sent to : " + obj.getTarget();
			deleteMAIL(obj.getId());
			return output;
		}
		catch(Exception e) {
			String output = "Queue is empty";
			return output;
		}
	}
	
	public void deleteMAIL(int id) {
		Map<String, Integer> param = new HashMap<>();
		param.put("id", id);
		restTemplate.delete(DELETE_MAIL, param);
	}
}
