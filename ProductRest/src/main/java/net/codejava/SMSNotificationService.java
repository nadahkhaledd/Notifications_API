package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SMSNotificationService {
	
	@Autowired
	private SMSNotificationRepository repo;

	public List<SMSNotificationEntity> listAll() {
		return repo.findAll();
	}
	
	public SMSNotificationEntity getByID(int id) {
		return repo.findById(id).get();
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
	
	public void save(SMSNotificationEntity notification) {
		repo.save(notification);
	}
}
