package cl.ubb.model;

import javax.persistence.Entity;

/**
 * Created by Felipe Cifuentes on 29-05-2017.
 */
@Entity
public class TitleCategory {
    private String identifier;
    private String name;

    public TitleCategory() {
    }

    public TitleCategory(String identifier, String name) {
        this.identifier = identifier;
        this.name = name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
