package cl.ubb.model;

import javax.persistence.Entity;
import java.util.LinkedList;

/**
 * Created by Felipe Cifuentes on 29-05-2017.
 */
@Entity
public class BorrowerCategory {
    private String identifier;
    private String name;
    private int maxNumberOfLoans;
    private LinkedList <LoanCondition> loanConditions;
    private LinkedList <Borrower> borrowers;

    public BorrowerCategory() {
    }

    public BorrowerCategory(String identifier, String name, int maxNumberOfLoans, LinkedList<LoanCondition> loanConditions, LinkedList<Borrower> borrowers) {
        this.identifier = identifier;
        this.name = name;
        this.maxNumberOfLoans = maxNumberOfLoans;
        this.loanConditions = loanConditions;
        this.borrowers = borrowers;
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

    public int getMaxNumberOfLoans() {
        return maxNumberOfLoans;
    }

    public void setMaxNumberOfLoans(int maxNumberOfLoans) {
        this.maxNumberOfLoans = maxNumberOfLoans;
    }

    public LinkedList<LoanCondition> getLoanConditions() {
        return loanConditions;
    }

    public void setLoanConditions(LinkedList<LoanCondition> loanConditions) {
        this.loanConditions = loanConditions;
    }

    public LinkedList<Borrower> getBorrowers() {
        return borrowers;
    }

    public void setBorrowers(LinkedList<Borrower> borrowers) {
        this.borrowers = borrowers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BorrowerCategory that = (BorrowerCategory) o;

        if (maxNumberOfLoans != that.maxNumberOfLoans) return false;
        if (identifier != null ? !identifier.equals(that.identifier) : that.identifier != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (loanConditions != null ? !loanConditions.equals(that.loanConditions) : that.loanConditions != null)
            return false;
        return borrowers != null ? borrowers.equals(that.borrowers) : that.borrowers == null;
    }

    @Override
    public int hashCode() {
        int result = identifier != null ? identifier.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + maxNumberOfLoans;
        result = 31 * result + (loanConditions != null ? loanConditions.hashCode() : 0);
        result = 31 * result + (borrowers != null ? borrowers.hashCode() : 0);
        return result;
    }
}
