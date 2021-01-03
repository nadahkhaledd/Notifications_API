package net.codejava;

import org.springframework.data.jpa.repository.JpaRepository;

public interface smsRepository extends JpaRepository<SMSTable, Integer> {

}
