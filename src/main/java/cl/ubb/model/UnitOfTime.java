package cl.ubb.model;

import javax.persistence.Entity;

/**
 * Created by Felipe Cifuentes on 29-05-2017.
 */
@Entity
public class UnitOfTime {
    private String identifier;
    private String name;

    public UnitOfTime() {
    }

    public UnitOfTime(String identifier, String name) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnitOfTime that = (UnitOfTime) o;

        if (identifier != null ? !identifier.equals(that.identifier) : that.identifier != null) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = identifier != null ? identifier.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
