package com.sagor.travel.repo;


import com.sagor.travel.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {
    Client findByClientName(String clientName);
    Optional<Client> findByEmail(String email);
}
