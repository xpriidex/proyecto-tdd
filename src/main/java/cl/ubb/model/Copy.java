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
}
