package cl.ubb.model;

/**
 * Created by Felipe Cifuentes on 29-05-2017.
 */
public class Title {
    private String identifier;
    private String name;
    private String year;
    private String format;
    private String replacementCost;
    private Subject subject;

    public Title() {
    }

    public Title(String identifier, String name, String year, String format, String replacementCost, Subject subject) {
        this.identifier = identifier;
        this.name = name;
        this.year = year;
        this.format = format;
        this.replacementCost = replacementCost;
        this.subject = subject;
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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
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
        return subject != null ? subject.equals(title.subject) : title.subject == null;
    }

    @Override
    public int hashCode() {
        int result = identifier != null ? identifier.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (format != null ? format.hashCode() : 0);
        result = 31 * result + (replacementCost != null ? replacementCost.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        return result;
    }
}
