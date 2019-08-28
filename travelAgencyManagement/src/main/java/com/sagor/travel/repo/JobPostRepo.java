package com.sagor.travel.repo;

import com.sagor.travel.entity.JobPost;
import com.sagor.travel.entity.Visatype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPostRepo extends JpaRepository<JobPost, Long> {
    JobPost findByName(String name);
}
