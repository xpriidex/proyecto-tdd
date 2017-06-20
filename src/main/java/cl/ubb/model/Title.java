package cl.ubb.model;

import javax.persistence.Entity;
import java.util.LinkedList;

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
    private TitleCategory titleCategory;
    private Subject subject;
    private LinkedList<Copy> copies;

    public Title() {
    }

    public Title(String identifier, String name, String year, String format, String replacementCost, TitleCategory titleCategory, Subject subject, LinkedList<Copy> copies) {
        this.identifier = identifier;
        this.name = name;
        this.year = year;
        this.format = format;
        this.replacementCost = replacementCost;
        this.titleCategory = titleCategory;
        this.subject = subject;
        this.copies = copies;
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

    public TitleCategory getTitleCategory() {
        return titleCategory;
    }

    public void setTitleCategory(TitleCategory titleCategory) {
        this.titleCategory = titleCategory;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public LinkedList<Copy> getCopies() {
        return copies;
    }

    public void setCopies(LinkedList<Copy> copies) {
        this.copies = copies;
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
        if (titleCategory != null ? !titleCategory.equals(title.titleCategory) : title.titleCategory != null)
            return false;
        if (subject != null ? !subject.equals(title.subject) : title.subject != null) return false;
        return copies != null ? copies.equals(title.copies) : title.copies == null;
    }

    @Override
    public int hashCode() {
        int result = identifier != null ? identifier.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (format != null ? format.hashCode() : 0);
        result = 31 * result + (replacementCost != null ? replacementCost.hashCode() : 0);
        result = 31 * result + (titleCategory != null ? titleCategory.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (copies != null ? copies.hashCode() : 0);
        return result;
    }
}
