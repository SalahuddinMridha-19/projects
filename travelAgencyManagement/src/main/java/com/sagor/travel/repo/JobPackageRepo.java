package com.sagor.travel.repo;


import com.sagor.travel.entity.JobPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPackageRepo extends JpaRepository<JobPackage, Long> {

}
