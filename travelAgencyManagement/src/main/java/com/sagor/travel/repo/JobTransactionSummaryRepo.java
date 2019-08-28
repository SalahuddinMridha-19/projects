package com.sagor.travel.repo;

import com.sagor.travel.entity.JobTransactionSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTransactionSummaryRepo extends JpaRepository<JobTransactionSummary, Long> {

}
