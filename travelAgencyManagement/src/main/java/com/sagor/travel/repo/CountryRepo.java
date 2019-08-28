package com.sagor.travel.repo;


import com.sagor.travel.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo extends JpaRepository<Country , Long> {
    Country findByName(String name);
}
