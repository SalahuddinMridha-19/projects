package com.sagor.pharmacymanagement.repo;


import com.sagor.pharmacymanagement.entity.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugRepo extends JpaRepository<Drug, Long> {
    Drug findByDrugName(String drugName);
    Drug findByDrugCode(String dc);

}
