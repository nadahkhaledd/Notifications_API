package net.code.java;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

public class DequeueSMS implements DequeueStrategy {
	
	private static final String GET_FIRST_ID_SMS = "http://localhost:8080/templates5/";
	private static final String DELETE_SMS = "http://localhost:8080/templates3/{id}";
	static RestTemplate restTemplate = new RestTemplate();
	
	public String dequeue() {
		try {
			SMS obj = restTemplate.getForObject(GET_FIRST_ID_SMS, SMS.class);
			String output = "Notification: [" + obj.getContent() + "] sent to : " + obj.getTarget();
			deleteSMS(obj.getId());
			return output;
		}
		catch(Exception e) {
			String output = "Queue is empty";
			return output;
		}
	}
	
	public void deleteSMS(int id) {
		Map<String, Integer> param = new HashMap<>();
		param.put("id", id);
		restTemplate.delete(DELETE_SMS, param);
	}
}
