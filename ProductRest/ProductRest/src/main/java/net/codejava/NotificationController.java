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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

	Queue<Notification> SMS = new LinkedList<>();
	Queue<Notification> MAIL = new LinkedList<>();
	
	
	@Autowired
	private TemplateService service;
	private NotificationService service2;
	private NotificationDB notify;
	
	public Notification prepareNotification(String msg, String[] values) {
		Notification obj = new Notification();
		//String [] values = {"hussien", "mobile"};
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
		return obj;
	}
	
	@GetMapping("/templates2/{type}/{category}")
	public ResponseEntity<?> getByType(@PathVariable String type ,@PathVariable String category,@RequestBody Request request ) {
		try {
			 Template template = service.getByType(type, category);
		     Notification obj = new Notification();
			 obj = prepareNotification(template.getText(), request.getValues());
			 if(request.getMethod().equalsIgnoreCase("sms"))
			 {
				 SMS.add(obj);
			 }
			 else
			 {
				 MAIL.add(obj);
			 }
			 System.out.println("Queue SMS: " + SMS);
			 System.out.println("Queue MAIL: " + MAIL);  
			 System.out.println("........");
			 return new ResponseEntity<>(template, HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Template>(HttpStatus.NOT_FOUND);
		}
	}
}
