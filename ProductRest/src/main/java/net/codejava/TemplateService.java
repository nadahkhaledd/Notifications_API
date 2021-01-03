package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemplateService {
	
	@Autowired
	private TemplateRepository repo;
	
	public List<TemplateEntity> listAll() {
		return repo.findAll();
	}
	
	public void save(TemplateEntity template) {
		repo.save(template);
	}
	
	public TemplateEntity getByID(int id) {
		return repo.findById(id).get();
	}

	public TemplateEntity getByType(String type, String category) {
		return repo.findByType(type,category);
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
}
