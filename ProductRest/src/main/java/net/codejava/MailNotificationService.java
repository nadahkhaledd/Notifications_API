package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailNotificationService {
	
	@Autowired
	private MailNotificationRepository repo;
	
	public List<MAIL> listAll() {
		return repo.findAll();
	}
	
	public MAIL getByID(int id) {
		return repo.findById(id).get();
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
	
	public void save(MAIL notification) {
		repo.save(notification);
	}
	
	
	public MAIL getFirstID()
	{
		
		return repo.findFirstID();
	}
	


}
