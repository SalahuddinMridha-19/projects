package com.sagor.travel.repo;

import com.sagor.travel.entity.StudentSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentSummaryRepo extends JpaRepository<StudentSummary, Long> {

}
