package com.booking.reservation.service;

import com.booking.reservation.entity.Client;
import com.booking.reservation.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client createClient(Client client) {
        return clientRepository.save(client);   //metoda per te krijuar nje kilent te ri
    }

    public Client updateClient(Long id, Client newClient) {
        Client existingClient = clientRepository.findById(id).orElse(null);
        if (existingClient != null) {
            existingClient.setName(newClient.getName());
            return clientRepository.save(existingClient);
        } else {
            System.out.println("Client not found ");
            return null;
        }


    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);


    }

    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

}
