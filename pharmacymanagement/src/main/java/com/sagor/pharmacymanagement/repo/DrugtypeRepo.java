package com.sagor.pharmacymanagement.repo;


import com.sagor.pharmacymanagement.entity.Drugtype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugtypeRepo extends JpaRepository<Drugtype, Long> {
    Drugtype findByTypeName(String typeName);
}
