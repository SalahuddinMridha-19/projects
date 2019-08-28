package com.sagor.travel.repo;

import com.sagor.travel.entity.JobType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTypeRepo extends JpaRepository<JobType, Long> {
    JobType findByName(String name);
}
