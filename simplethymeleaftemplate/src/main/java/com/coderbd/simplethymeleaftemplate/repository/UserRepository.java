package com.coderbd.simplethymeleaftemplate.repository;

import com.coderbd.simplethymeleaftemplate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
