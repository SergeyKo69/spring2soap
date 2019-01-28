package ru.kogut.enterprise.ws.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kogut.enterprise.services.ClientService;
import ru.kogut.enterprise.ws.clients.Client;
import ru.kogut.enterprise.ws.clients.GetAllClientsResponse;
import ru.kogut.enterprise.ws.clients.GetAnswerResponse;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientRepositoryWS {

    @Autowired
    private ClientService clientService;


    public GetAnswerResponse saveClient(Client client) {
        try {
            ru.kogut.enterprise.models.Client clientDb =
                    convertClientXmlToClientDb(client);
            clientService.saveClient(clientDb);
            return new GetAnswerResponse("OK", clientDb.getId());
        }catch (Exception e){
            return new GetAnswerResponse("ERROR");
        }
    }

    public Client getClientById(String id) {
        return convertClientDbToClientXml(clientService.getClientById(id));
    }

     public GetAllClientsResponse getAllClients() {
        List<ru.kogut.enterprise.models.Client> listClientDb =
                clientService.getAllClients();
        GetAllClientsResponse getAllClientsResponse = new GetAllClientsResponse();
        List<Client> listClientXml = new ArrayList<>();
        for (int i = 0; i < listClientDb.size(); i++) {
            listClientXml.add(convertClientDbToClientXml(listClientDb.get(i)));
        }
        getAllClientsResponse.setClientList(listClientXml);
        return getAllClientsResponse;
    }

    public GetAnswerResponse updateClient(Client client) {
        return saveClient(client);
    }

    public GetAnswerResponse deleteClient(Client client) {
        try {
            clientService.deleteClient(convertClientXmlToClientDb(client));
            return new GetAnswerResponse("OK");
        }catch (Exception e){
            return new GetAnswerResponse("ERROR");
        }
    }

    public ru.kogut.enterprise.models.Client convertClientXmlToClientDb(Client client){
        if (client == null) return null;
        ru.kogut.enterprise.models.Client clientDb = new ru.kogut.enterprise.models.Client();
        if (client.getId() != null) {
            clientDb.setId(client.getId());
        }
        clientDb.setTitle(client.getTitle());
        clientDb.setAddress(client.getAddress());
        clientDb.setDelete(client.getDelete());
        return clientDb;
    }

    public Client convertClientDbToClientXml(ru.kogut.enterprise.models.Client client){
        if (client == null) return null;
        Client clientWs = new Client();
        clientWs.setId(client.getId());
        clientWs.setTitle(client.getTitle());
        clientWs.setAddress(client.getAddress());
        clientWs.setDelete(client.getDelete());
        return clientWs;
    }
}
