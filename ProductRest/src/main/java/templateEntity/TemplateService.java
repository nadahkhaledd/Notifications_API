package templateEntity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemplateService {
	
	@Autowired
	private TemplateRepository repo;
	
	public List<Template> listAll() {
		return repo.findAll();
	}
	
	public void save(Template template) {
		repo.save(template);
	}
	
	public Template getByID(int id) {
		return repo.findById(id).get();
	}

	public Template getByType(String type, String category) {
		return repo.findByType(type, category);
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
}
