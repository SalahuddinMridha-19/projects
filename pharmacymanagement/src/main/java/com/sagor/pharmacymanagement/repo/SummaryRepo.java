package com.sagor.pharmacymanagement.repo;

import com.sagor.pharmacymanagement.entity.Summary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SummaryRepo extends JpaRepository<Summary, Long> {
    Summary findByDrugName(String drugName);


}
