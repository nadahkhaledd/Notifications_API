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
	
	public static void dequeueSMS() {
		try {
			SMS obj = restTemplate.getForObject(GET_FIRST_ID_SMS, SMS.class);
			System.out.println("Notification sent : " + obj.getContent() + "\n");
			deleteSMS(obj.getId());
		}
		catch(Exception e) {
			System.out.println("Queue is empty");
		}
	}
	
	public static void deleteSMS(int id) {
		Map<String, Integer> param = new HashMap<>();
		param.put("id", id);
		restTemplate.delete(DELETE_SMS, param);
	}
	
	public static void dequeueMAIL() {
		try {
			MAIL obj = restTemplate.getForObject(GET_FIRST_ID_MAIL, MAIL.class);
			System.out.println("Notification sent: " + obj.getContent() + "\n");
			deleteMAIL(obj.getId());
		} 
		catch (Exception e)  {
			System.out.println("Queue is empty");
		}
	}
	
	public static void deleteMAIL(int id) {
		Map<String, Integer> param = new HashMap<>();
		param.put("id", id);
		restTemplate.delete(DELETE_MAIL, param);
	}
}
