//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.01.26 at 08:12:10 PM MSK 
//


package ru.kogut.enterprise.ws.clients;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.kogut.clients package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.kogut.clients
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetClientByIdRequest }
     * 
     */
    public GetClientByIdRequest createGetClientRequest() {
        return new GetClientByIdRequest();
    }

    /**
     * Create an instance of {@link GetClientResponse }
     * 
     */
    public GetClientResponse createGetClientResponse() {
        return new GetClientResponse();
    }

    public GetAllClientsResponse createGetAllClientsResponse() {
        return new GetAllClientsResponse();
    }

    public DeleteClientRequest createDeleteClientRequest(){ return new DeleteClientRequest(); }

    public SaveClientRequest createSaveClientResponse() {
        return new SaveClientRequest();
    }

    public UpdateClientRequest createUpdateClientRequest() { return new UpdateClientRequest(); }

    /**
     * Create an instance of {@link Client }
     * 
     */
    public Client createClient() {
        return new Client();
    }

}