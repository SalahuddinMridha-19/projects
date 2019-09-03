package com.sagor.pharmacymanagement.repo;

import com.sagor.pharmacymanagement.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {


    Optional<Role> findByRolename(String rolename);
    boolean existsRoleByRolename(String rolename);
}
