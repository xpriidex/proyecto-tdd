package cl.ubb.model;

import javax.persistence.Entity;

/**
 * Created by Felipe Cifuentes on 05-06-2017.
 */
@Entity
public class Equipment extends Title {
    private String description;

    public Equipment(String identifier, String name, String year, String format, String replacementCost, String idTitleCategory, String idSubject, String description) {
        super(identifier, name, year, format, replacementCost, idTitleCategory, idSubject);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Equipment equipment = (Equipment) o;

        return description != null ? description.equals(equipment.description) : equipment.description == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
