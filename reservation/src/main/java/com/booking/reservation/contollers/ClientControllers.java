package com.booking.reservation.contollers;

import com.booking.reservation.entity.Client;
import com.booking.reservation.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientControllers {
    @Autowired
    private ClientService clientService;

    @PostMapping ("/create")
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }
@PutMapping("/update/{id}")
    public Client updateClient(@PathVariable Long id,@RequestBody Client client){
        return clientService.updateClient(id,client);
}
@DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
}
    @GetMapping("/getAllClients")
    public List<Client> getAllClient() {
        return clientService.getAllClient();
    }

    @GetMapping("/getClientById/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

}
