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
	public List<TemplateEntity> list() {
		return service.listAll();
	}
	
	@GetMapping("/templates/{id}")
	public ResponseEntity<TemplateEntity> getByID(@PathVariable Integer id) {
		try {
			TemplateEntity template = service.getByID(id);
			return new ResponseEntity<TemplateEntity>(template, HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<TemplateEntity>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/templates")
	public void add(@RequestBody TemplateEntity template) {
		service.save(template);
	}
	
	@PutMapping("/templates/{id}")
	public ResponseEntity<?> update(@RequestBody TemplateEntity template, @PathVariable int id) {
		try {
			TemplateEntity existtemplate = service.getByID(id);
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
