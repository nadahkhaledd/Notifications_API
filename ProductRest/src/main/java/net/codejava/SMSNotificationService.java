package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SMSNotificationService {
	
	@Autowired
	private SMSNotificationRepository repo;

	public List<SMS> listAll() {
		return repo.findAll();
	}
	
	public SMS getByID(int id) {
		return repo.findById(id).get();
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
	
	public void save(SMS notification) {
		repo.save(notification);
	}
	
	public SMS getFirstID()
	{
		
		return repo.findFirstID();
	}
}
