package com.sagor.pharmacymanagement.repo;


import com.sagor.pharmacymanagement.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Long> {

}
