package ru.kogut.enterprise.ws.clients;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "address",
        "title",
        "delete"
})
@XmlRootElement(name = "saveClientRequest")
public class SaveClientRequest {

    @XmlElement(required = false)
    private String address;
    @XmlElement(required = true)
    private String title;
    @XmlElement(required = false)
    private boolean delete;

    public boolean getDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
