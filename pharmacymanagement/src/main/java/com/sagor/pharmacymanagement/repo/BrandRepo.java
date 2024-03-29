package com.sagor.pharmacymanagement.repo;

import com.sagor.pharmacymanagement.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepo extends JpaRepository<Brand, Long> {
    Brand findByBrandName(String brandName);
}
