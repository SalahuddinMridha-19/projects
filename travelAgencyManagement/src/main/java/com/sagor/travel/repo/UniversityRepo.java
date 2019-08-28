package com.sagor.travel.repo;

import com.sagor.travel.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepo extends JpaRepository<University, Long> {
    University findByName(String name);
}
