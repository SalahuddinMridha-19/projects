package com.sagor.travel.repo;


import com.sagor.travel.entity.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyRepo extends JpaRepository<Agency, Long> {
    Agency findByName(String name);
}
