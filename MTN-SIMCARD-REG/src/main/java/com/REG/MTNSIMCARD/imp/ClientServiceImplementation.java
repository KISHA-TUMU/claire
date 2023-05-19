package com.REG.MTNSIMCARD.imp;

import com.REG.MTNSIMCARD.Models.Client;
import com.REG.MTNSIMCARD.Repository.ClientRepository;
import com.REG.MTNSIMCARD.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServiceImplementation implements ClientService {

   private  ClientRepository repo;
    private ClientRepository clientRepository;
    @Autowired
    public ClientServiceImplementation(ClientRepository repo, ClientRepository clientRepository) {
        this.repo = repo;
        this.clientRepository = clientRepository;
    }


    @Override
    public List<Client> findAllClients() {
        return repo.findAll();
    }

    @Override
    public Client saveclient(Client client) {
        return repo.save(client);
    }

    @Override
    public Client findClientById(long client) {
        Client Client1 = repo.findById(client);
        return Client1 ;
    }

//    @Override
//    public List<Client> findClientById_No(Client client) {
//       // List<Client> listClientById_no = repo.findById_no(client);
//       // return listClientById_no;
//        return repo.findById_no(client);
//    }

    @Override
    public Client updateClient(Client client) {
        return repo.save(client);
    }

    @Override
    public void deleteClient(long client) {
        clientRepository.deleteById(client);
    }


}
