package cl.ubb.model;

import javax.persistence.Entity;

/**
 * Created by Felipe Cifuentes on 05-06-2017.
 */
@Entity
public class Multimedia extends Title {
    private String plataformEspecification;

    public Multimedia(String identifier, String name, String year, String format, String replacementCost, String idTitleCategory, String idSubject, String plataformEspecification) {
        super(identifier, name, year, format, replacementCost, idTitleCategory, idSubject);
        this.plataformEspecification = plataformEspecification;
    }

    public String getPlataformEspecification() {
        return plataformEspecification;
    }

    public void setPlataformEspecification(String plataformEspecification) {
        this.plataformEspecification = plataformEspecification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Multimedia that = (Multimedia) o;

        return plataformEspecification != null ? plataformEspecification.equals(that.plataformEspecification) : that.plataformEspecification == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (plataformEspecification != null ? plataformEspecification.hashCode() : 0);
        return result;
    }
}
