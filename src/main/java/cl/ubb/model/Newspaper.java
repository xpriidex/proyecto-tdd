package cl.ubb.model;

import javax.persistence.Entity;

/**
 * Created by Felipe Cifuentes on 05-06-2017.
 */
@Entity
public class Newspaper extends Title{
    private String  day;
    private String month;

    public Newspaper(String identifier, String name, String year, String format, String replacementCost, String idTitleCategory, String idSubject, String day, String month) {
        super(identifier, name, year, format, replacementCost, idTitleCategory, idSubject);
        this.day = day;
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Newspaper newspaper = (Newspaper) o;

        if (day != null ? !day.equals(newspaper.day) : newspaper.day != null) return false;
        return month != null ? month.equals(newspaper.month) : newspaper.month == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (day != null ? day.hashCode() : 0);
        result = 31 * result + (month != null ? month.hashCode() : 0);
        return result;
    }
}
