package ru.kogut.enterprise.models;

import org.intellij.lang.annotations.Identifier;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
public class AbstractEntity {

    @Id
    @Identifier
    @Column(name = "id", nullable = false)
    private String id = UUID.randomUUID().toString();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
