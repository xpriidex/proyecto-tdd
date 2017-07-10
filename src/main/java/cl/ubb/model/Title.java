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


}
