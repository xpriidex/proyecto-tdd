package cl.ubb.model;

import javax.persistence.Entity;

/**
 * Created by Felipe Cifuentes on 29-05-2017.
 */
@Entity
public class Title {
    private String identifier;
    private String name;
    private String year;
    private String format;
    private String replacementCost;
    private String idTitleCategory;
    private String  idSubject;

    public Title() {
    }

    public Title(String identifier, String name, String year, String format, String replacementCost, String idTitleCategory, String idSubject) {
        this.identifier = identifier;
        this.name = name;
        this.year = year;
        this.format = format;
        this.replacementCost = replacementCost;
        this.idTitleCategory = idTitleCategory;
        this.idSubject = idSubject;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(String replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getIdTitleCategory() {
        return idTitleCategory;
    }

    public void setIdTitleCategory(String idTitleCategory) {
        this.idTitleCategory = idTitleCategory;
    }

    public String getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(String idSubject) {
        this.idSubject = idSubject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Title title = (Title) o;

        if (identifier != null ? !identifier.equals(title.identifier) : title.identifier != null) return false;
        if (name != null ? !name.equals(title.name) : title.name != null) return false;
        if (year != null ? !year.equals(title.year) : title.year != null) return false;
        if (format != null ? !format.equals(title.format) : title.format != null) return false;
        if (replacementCost != null ? !replacementCost.equals(title.replacementCost) : title.replacementCost != null)
            return false;
        if (idTitleCategory != null ? !idTitleCategory.equals(title.idTitleCategory) : title.idTitleCategory != null)
            return false;
        return idSubject != null ? idSubject.equals(title.idSubject) : title.idSubject == null;
    }

    @Override
    public int hashCode() {
        int result = identifier != null ? identifier.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (format != null ? format.hashCode() : 0);
        result = 31 * result + (replacementCost != null ? replacementCost.hashCode() : 0);
        result = 31 * result + (idTitleCategory != null ? idTitleCategory.hashCode() : 0);
        result = 31 * result + (idSubject != null ? idSubject.hashCode() : 0);
        return result;
    }
}
