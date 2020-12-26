package net.codejava;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TemplateRepository extends JpaRepository<Template, Integer> {
	
	@Query("SELECT text FROM Template t WHERE t.type = 'type'")
    public Template findByType(String type);

}
