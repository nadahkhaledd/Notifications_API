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
	
	public Notification obj = new Notification();
	
	@Autowired
	private TemplateService service;
	
	public void prepareNotification(String msg) {
		String [] values = {"hussien", "mobile"};
		int index = 0;
		int i = 0;
		while(true) {
			if(msg.indexOf("$", index) == -1) {
				break;
			}
			String temp = msg.substring(msg.indexOf("$", index), msg.indexOf("}", index)+1);
			index = msg.indexOf("}", index)+1;
			msg = msg.replace(temp, values[i]);
			i++;
		}
		obj.setContent(msg);
	}
	
	@GetMapping("/templates2/{type}")
	public ResponseEntity<?> getByType(@PathVariable String type) {
		try {
			 List<Template> templates = service.getByType(type);
			 for(int i = 0; i < templates.size(); i++) {
				 prepareNotification(templates.get(i).getText());
				 SMS.add(obj);
			 }
		     System.out.println("Queue: " + SMS);
			 System.out.println("........");
			 return new ResponseEntity<>(templates, HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Template>(HttpStatus.NOT_FOUND);
		}
	}
}
