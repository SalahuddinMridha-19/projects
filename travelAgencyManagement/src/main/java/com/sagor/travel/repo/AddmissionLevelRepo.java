package com.sagor.travel.repo;

import com.sagor.travel.entity.AddmissionLevel;
import com.sagor.travel.entity.Visatype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddmissionLevelRepo extends JpaRepository<AddmissionLevel, Long> {
    AddmissionLevel findByName(String name);
}
