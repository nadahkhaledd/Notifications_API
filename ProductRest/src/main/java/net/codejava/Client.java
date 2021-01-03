package net.codejava;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Client {
	public static void main(String[] args) {
		GETALL();
		GETBYID();
		 //CREATETEMPLATE();
		 //UPDATETEMPLATE();
		// DELETETEMPLATE();
		
	}
	private static final String GET_ALL = "http://localhost:8080/templates";
	private static final String GET_BY_ID = "http://localhost:8080/templates/{id}";
	private static final String CREATE_TEMPLATE = "http://localhost:8080/templates";
	private static final String UPDATE_TEMPLATE = "http://localhost:8080/templates/{id}";
	private static final String DELETE_TEMPLATE = "http://localhost:8080/templates/{id}";
	
	static RestTemplate restTemplate = new RestTemplate();
	private static void GETALL()
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		
		ResponseEntity<String> result = restTemplate.exchange(GET_ALL, HttpMethod.GET, entity, String.class);
				System.out.println(result);
	}
	
	private static void GETBYID()
	{
		Map<String, Integer> param = new HashMap<>();
		param.put("id", 1);
		
		Template temp = restTemplate.getForObject(GET_BY_ID, Template.class, param);
		System.out.println(temp.getText());
		System.out.println(temp.getType());
		System.out.println(temp.getCategory());
	};
	
	private static void CREATETEMPLATE()
	{
		Template temp = new Template("new template", "confirmation", "english");
		ResponseEntity<Template> temp2 = restTemplate.postForEntity(CREATE_TEMPLATE, temp, Template.class);
		System.out.println(temp2.getBody());
	}
	
	private static void UPDATETEMPLATE()
	{
		Map<String, Integer> param = new HashMap<>();
		param.put("id", 11);
		Template temp = new Template("updated template",11, "confirmation", "english"	);
		restTemplate.put(UPDATE_TEMPLATE, temp, param);
	}
	
	private static void DELETETEMPLATE()
	{
		Map<String, Integer> param = new HashMap<>();
		param.put("id", 10);
		restTemplate.delete(DELETE_TEMPLATE, param);
	}
	
	

}
