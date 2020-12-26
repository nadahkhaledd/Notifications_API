package net.codejava;


import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

	Queue<Notification> SMS = new LinkedList<>();
	
	public static Notification obj = new Notification();
	
	@Autowired
	private TemplateService service;
	
	@GetMapping("/templates/{type}")
	public ResponseEntity<Template> get(@PathVariable String type) {
		try {
			 Template template = service.get(type);
			 return new ResponseEntity<Template>(template, HttpStatus.OK);
			 //System.out.println(template.getTemplate());
			 /*obj.prepareNotification(template.getTemplate());
			 System.out.println(obj.getContent());
			 SMS.add(obj);*/
		}
		catch(NoSuchElementException e) {
			//System.out.println("Not Found");
			return new ResponseEntity<Template>(HttpStatus.NOT_FOUND);
		}
	}
	
}
