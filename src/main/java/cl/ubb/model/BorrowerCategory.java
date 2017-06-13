package cl.ubb.model;

import javax.persistence.Entity;

/**
 * Created by Felipe Cifuentes on 29-05-2017.
 */
@Entity
public class BorrowerCategory {
    String indentifier;
    String name;
    int maxNumberOfLoans;

    public BorrowerCategory() {
    }

    public BorrowerCategory(String indentifier, String name, int maxNumberOfLoans) {
        this.indentifier = indentifier;
        this.name = name;
        this.maxNumberOfLoans = maxNumberOfLoans;
    }

    public String getIndentifier() {
        return indentifier;
    }

    public void setIndentifier(String indentifier) {
        this.indentifier = indentifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxNumberOfLoans() {
        return maxNumberOfLoans;
    }

    public void setMaxNumberOfLoans(int maxNumberOfLoans) {
        this.maxNumberOfLoans = maxNumberOfLoans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BorrowerCategory that = (BorrowerCategory) o;

        if (maxNumberOfLoans != that.maxNumberOfLoans) return false;
        if (indentifier != null ? !indentifier.equals(that.indentifier) : that.indentifier != null) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = indentifier != null ? indentifier.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + maxNumberOfLoans;
        return result;
    }
}
