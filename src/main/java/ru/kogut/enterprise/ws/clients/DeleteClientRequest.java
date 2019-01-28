package ru.kogut.enterprise.ws.clients;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "client"
})
@XmlRootElement(name = "deleteClientRequest")
public class DeleteClientRequest {

    @XmlElement(required = true)
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
