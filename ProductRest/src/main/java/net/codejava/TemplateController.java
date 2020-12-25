package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemplateController {
	
	@Autowired
	private TemplateService service;
	
	@GetMapping("/templates")
	public List<Template> list() {
		return service.listAll();
	}

}
