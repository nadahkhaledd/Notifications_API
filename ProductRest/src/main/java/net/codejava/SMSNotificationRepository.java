package net.codejava;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SMSNotificationRepository extends JpaRepository<SMS, Integer> {
	
	@Query("SELECT s FROM sms s ORDER BY s.id ASC LIMIT 1")
    public Template findFirstID();
}
