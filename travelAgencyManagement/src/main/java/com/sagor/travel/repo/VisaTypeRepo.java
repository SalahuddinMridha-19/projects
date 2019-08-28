package com.sagor.travel.repo;

import com.sagor.travel.entity.Visatype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisaTypeRepo extends JpaRepository<Visatype, Long> {
    Visatype findByTypeName(String typeName);
}
