package ru.kogut.enterprise.services;

import ru.kogut.enterprise.models.Client;

import java.util.List;

public interface ClientServiceInt {

    void saveClient(Client client);
    Client getClientById(String id);
    List<Client> getAllClients();
    void updateClient(Client client);
    void deleteClient(Client client);

}
