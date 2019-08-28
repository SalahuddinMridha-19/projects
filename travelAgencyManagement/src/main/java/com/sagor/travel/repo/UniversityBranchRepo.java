package com.sagor.travel.repo;



import com.sagor.travel.entity.UniversityBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityBranchRepo extends JpaRepository<UniversityBranch, Long> {
    UniversityBranch findByName(String name);
}
