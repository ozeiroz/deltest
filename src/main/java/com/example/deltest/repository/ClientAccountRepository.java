package com.example.deltest.repository;

import com.example.deltest.model.ClientAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientAccountRepository extends JpaRepository<ClientAccount, Long> {

    @Query(value = "SELECT * FROM client_account", nativeQuery = true)
    List<ClientAccount> getAllClients();
}
