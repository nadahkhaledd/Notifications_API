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

	Queue<Notifications> SMS = new LinkedList<>();
	Queue<Notifications> MAIL = new LinkedList<>();
	
	
	@Autowired
	private TemplateService service;
	@Autowired
	private smsService serviceSMS;
	@Autowired
	private MAILService serviceMAIL;
	
	public Notifications prepareNotification(String msg, String[] values) {
		Notifications obj = new Notifications();
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
		
		SMSTable notifySMS = new SMSTable();
		mailtable notifyMAIL = new mailtable();
		
		if(method.equalsIgnoreCase("sms"))
		{
			notifySMS.setContent(content);
			notifySMS.setTarget(target);
			serviceSMS.save(notifySMS);
		}
		else
		{
			notifyMAIL.setContent(content);
			notifyMAIL.setTarget(target);
			serviceMAIL.save(notifyMAIL);
		}
		
		
	}
	
	@GetMapping("/templates2/{type}/{category}")
	public ResponseEntity<?> getRequest(@PathVariable String type ,@PathVariable String category,@RequestBody Request request ) {
		try {
			 Template template = service.getByType(type, category);
		     Notifications obj = new Notifications();
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
