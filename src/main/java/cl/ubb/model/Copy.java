package cl.ubb.model;

import javax.persistence.Entity;

/**
 * Created by Felipe Cifuentes on 29-05-2017.
 */
@Entity
public class Copy {
    private String identifier;
    private String acquisitionDate;
    private Title title;

    public Copy() {
    }

    public Copy(String identifier, String acquisitionDate, Title title) {
        this.identifier = identifier;
        this.acquisitionDate = acquisitionDate;
        this.title = title;
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

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Copy copy = (Copy) o;

        if (identifier != null ? !identifier.equals(copy.identifier) : copy.identifier != null) return false;
        if (acquisitionDate != null ? !acquisitionDate.equals(copy.acquisitionDate) : copy.acquisitionDate != null)
            return false;
        return title != null ? title.equals(copy.title) : copy.title == null;
    }

    @Override
    public int hashCode() {
        int result = identifier != null ? identifier.hashCode() : 0;
        result = 31 * result + (acquisitionDate != null ? acquisitionDate.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
