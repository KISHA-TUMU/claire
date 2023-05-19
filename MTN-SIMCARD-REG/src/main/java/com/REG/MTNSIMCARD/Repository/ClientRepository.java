package com.REG.MTNSIMCARD.Repository;

import com.REG.MTNSIMCARD.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    //List<Client> findById_no(Client client);
    Client findById(long client);
}
