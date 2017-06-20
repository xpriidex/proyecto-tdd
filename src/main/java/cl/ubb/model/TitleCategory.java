package cl.ubb.model;

import javax.persistence.Entity;
import java.util.LinkedList;

/**
 * Created by Felipe Cifuentes on 29-05-2017.
 */
@Entity
public class TitleCategory {
    private String identifier;
    private String name;
    private LinkedList<Title> titles;
    private LinkedList<LoanCondition> loanConditions;

    public TitleCategory() {
    }

    public TitleCategory(String identifier, String name, LinkedList<Title> titles, LinkedList<LoanCondition> loanConditions) {
        this.identifier = identifier;
        this.name = name;
        this.titles = titles;
        this.loanConditions = loanConditions;
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

    public LinkedList<Title> getTitles() {
        return titles;
    }

    public void setTitles(LinkedList<Title> titles) {
        this.titles = titles;
    }

    public LinkedList<LoanCondition> getLoanConditions() {
        return loanConditions;
    }

    public void setLoanConditions(LinkedList<LoanCondition> loanConditions) {
        this.loanConditions = loanConditions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TitleCategory that = (TitleCategory) o;

        if (identifier != null ? !identifier.equals(that.identifier) : that.identifier != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (titles != null ? !titles.equals(that.titles) : that.titles != null) return false;
        return loanConditions != null ? loanConditions.equals(that.loanConditions) : that.loanConditions == null;
    }

    @Override
    public int hashCode() {
        int result = identifier != null ? identifier.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (titles != null ? titles.hashCode() : 0);
        result = 31 * result + (loanConditions != null ? loanConditions.hashCode() : 0);
        return result;
    }
}
