package com.sagor.travel.repo;

import com.sagor.travel.entity.Nominee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface NomineeRepo extends JpaRepository<Nominee, Long> {

    Nominee findByName(String name);


}
