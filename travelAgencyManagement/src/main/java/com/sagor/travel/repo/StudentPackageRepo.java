package com.sagor.travel.repo;

import com.sagor.travel.entity.StudentPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPackageRepo extends JpaRepository<StudentPackage, Long> {

}
