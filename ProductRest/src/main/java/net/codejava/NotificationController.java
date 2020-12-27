package net.codejava;


import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

	Queue<Notification> SMS = new LinkedList<>();
	Queue<Notification> MAIL = new LinkedList<>();
	
	
	@Autowired
	private TemplateService service;
	@Autowired
	private NotificationService service2;
	
	public Notification prepareNotification(String msg, String[] values) {
		Notification obj = new Notification();
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
	
	public void saveNotification(String content, String method, String target) {
		NotificationDB notify = new NotificationDB();
		notify.setContent(content);
		notify.setMethod(method);
		notify.setTarget(target);
		service2.save(notify);
	}
	
	@GetMapping("/templates2/{type}/{category}")
	public ResponseEntity<?> getRequest(@PathVariable String type ,@PathVariable String category,@RequestBody Request request ) {
		try {
			 Template template = service.getByType(type, category);
		     Notification obj = new Notification();
			 obj = prepareNotification(template.getText(), request.getValues());
			 if(request.getMethod().equalsIgnoreCase("sms"))
			 {
				 SMS.add(obj);
			 }
			 else if(request.getMethod().equalsIgnoreCase("mail"))
			 {
				 MAIL.add(obj);
			 }
			 saveNotification(obj.getContent(), request.getMethod(), request.getTarget());
			 return new ResponseEntity<>(template, HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Template>(HttpStatus.NOT_FOUND);
		}
	}
}
