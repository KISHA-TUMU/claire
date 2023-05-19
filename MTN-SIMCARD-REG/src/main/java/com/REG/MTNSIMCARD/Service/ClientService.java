package com.REG.MTNSIMCARD.Service;

import com.REG.MTNSIMCARD.Models.Client;
import com.REG.MTNSIMCARD.db.ClientDb;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ClientService {
    List<Client> findAllClients();
    Client saveclient(Client client);
    Client findClientById(long client);
    //List<Client> findClientById_No(Client client);
    Client updateClient(Client client);
    void deleteClient(long client);
}
