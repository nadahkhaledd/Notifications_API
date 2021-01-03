package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class smsService {
	
	@Autowired
	private smsRepository repo;

	public List<SMSTable> listAll() {
		return repo.findAll();
	}
	
	public SMSTable getByID(int id) {
		return repo.findById(id).get();
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
	
	public void save(SMSTable notification) {
		repo.save(notification);
	}
}
