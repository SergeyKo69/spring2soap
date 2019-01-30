package ru.kogut.enterprise.ws.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.kogut.enterprise.ws.clients.*;
import ru.kogut.enterprise.ws.clients.GetAnswerResponse;
import ru.kogut.enterprise.ws.repository.ClientRepositoryWS;

@Endpoint
public class ClientEndpoint {

    private static final String NAMESPACE_URI = "http://kogut.ru/ws/clients";

    private ClientRepositoryWS clientRepository;

    @Autowired
    public ClientEndpoint(ClientRepositoryWS clientRepository) {
        this.clientRepository = clientRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "saveClientRequest")
    @ResponsePayload
    public GetAnswerResponse saveClient(@RequestPayload final SaveClientRequest request) {
        Client client = new Client();
        client.setTitle(request.getTitle());
        client.setAddress(request.getAddress());
        client.setDelete(request.getDelete());
        return clientRepository.saveClient(client);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateClientRequest")
    @ResponsePayload
    public GetAnswerResponse updateClient(@RequestPayload final UpdateClientRequest request) {
        return clientRepository.updateClient(request.getClient());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getClientByIdRequest")
    @ResponsePayload
    public GetClientResponse getClientById(@RequestPayload final GetClientByIdRequest request) {
        GetClientResponse response = new GetClientResponse();
        Client client = clientRepository.getClientById(request.getId());
        if (client == null){
            response.setStatus("Client not found");
        }else{
            response.setClient(client);
            response.setStatus("200");
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllClientsRequest")
    @ResponsePayload
    public GetAllClientsResponse getAllClients() {
        return clientRepository.getAllClients();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteClientRequest")
    @ResponsePayload
    public GetAnswerResponse deleteClient(@RequestPayload final DeleteClientRequest request) {
        return clientRepository.deleteClient(request.getClient());
    }
}
