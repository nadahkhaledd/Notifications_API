package net.codejava;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

public class Client {
	
	private static final String GET_FIRST_ID_SMS = "http://localhost:8080/templates5/";
	private static final String DELETE_SMS = "http://localhost:8080/templates3/{id}";
	private static final String GET_FIRST_ID_MAIL = "http://localhost:8080/templates6/";
	private static final String DELETE_MAIL = "http://localhost:8080/templates4/{id}";
	static RestTemplate restTemplate = new RestTemplate();
	
	public static String dequeueSMS() {
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
	
	public static void deleteSMS(int id) {
		Map<String, Integer> param = new HashMap<>();
		param.put("id", id);
		restTemplate.delete(DELETE_SMS, param);
	}
	
	public static String dequeueMAIL() {
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
	
	public static void deleteMAIL(int id) {
		Map<String, Integer> param = new HashMap<>();
		param.put("id", id);
		restTemplate.delete(DELETE_MAIL, param);
	}
}
