package net.codejava;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemplateController {
	
	@Autowired
	private TemplateService service;
	
	@GetMapping("/templates")
	public List<Template> list() {
		return service.listAll();
	}
	
	@GetMapping("/templates/{id}")
	public ResponseEntity<Template> getByID(@PathVariable Integer id) {
		try {
			Template template = service.getByID(id);
			return new ResponseEntity<Template>(template, HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Template>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/templates")
	public void add(@RequestBody Template template) {
		service.save(template);
	}
	
	@PutMapping("/templates/{id}")
	public ResponseEntity<?> update(@RequestBody Template template, @PathVariable int id) {
		try {
			Template existtemplate = service.getByID(id);
			service.save(template);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/templates/{id}")
	public void delete(@PathVariable int id) {
		service.delete(id);
	}
}
