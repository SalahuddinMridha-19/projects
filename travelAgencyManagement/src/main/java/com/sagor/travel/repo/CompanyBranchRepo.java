package com.sagor.travel.repo;



import com.sagor.travel.entity.CompanyBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyBranchRepo extends JpaRepository<CompanyBranch, Long> {
    CompanyBranch findByName(String name);
}
