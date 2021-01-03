package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MAILService {
	
	@Autowired
	private MAILRepository repo;
	
	public List<mailtable> listAll() {
		return repo.findAll();
	}
	
	public mailtable getByID(int id) {
		return repo.findById(id).get();
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
	
	public void save(mailtable notification) {
		repo.save(notification);
	}
	
	


}
