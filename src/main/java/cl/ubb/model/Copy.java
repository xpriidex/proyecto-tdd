package cl.ubb.model;

import javax.persistence.Entity;

/**
 * Created by Felipe Cifuentes on 29-05-2017.
 */
@Entity
public class Copy {
    private String identifier;
    private String acquisitionDate;
    private String idTitle;

    public Copy() {
    }

    public Copy(String identifier, String acquisitionDate, String idTitle) {
        this.identifier = identifier;
        this.acquisitionDate = acquisitionDate;
        this.idTitle = idTitle;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(String acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public String getIdTitle() {
        return idTitle;
    }

    public void setIdTitle(String idTitle) {
        this.idTitle = idTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Copy copy = (Copy) o;

        if (identifier != null ? !identifier.equals(copy.identifier) : copy.identifier != null) return false;
        if (acquisitionDate != null ? !acquisitionDate.equals(copy.acquisitionDate) : copy.acquisitionDate != null)
            return false;
        return idTitle != null ? idTitle.equals(copy.idTitle) : copy.idTitle == null;
    }

    @Override
    public int hashCode() {
        int result = identifier != null ? identifier.hashCode() : 0;
        result = 31 * result + (acquisitionDate != null ? acquisitionDate.hashCode() : 0);
        result = 31 * result + (idTitle != null ? idTitle.hashCode() : 0);
        return result;
    }
}
