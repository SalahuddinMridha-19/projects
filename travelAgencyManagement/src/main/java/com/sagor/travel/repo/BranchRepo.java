package com.sagor.travel.repo;


import com.sagor.travel.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepo extends JpaRepository<Branch, Long> {
    Branch findByName(String name);
}
