package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NotificationService {
	
	@Autowired
	private NotificationRepository repo;

	public List<NotificationDB> listAll() {
		return repo.findAll();
	}
	
	public NotificationDB getByID(int id) {
		return repo.findById(id).get();
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
	public void save(NotificationDB notification) {
		repo.save(notification);
	}
}
