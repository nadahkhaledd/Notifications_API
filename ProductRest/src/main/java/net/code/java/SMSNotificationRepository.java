package net.code.java;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SMSNotificationRepository extends JpaRepository<SMS, Integer> {
	
	@Query(value="Select * from sms t order by t.id ASC LIMIT 1", nativeQuery = true)
    public SMS findFirstID();
}
