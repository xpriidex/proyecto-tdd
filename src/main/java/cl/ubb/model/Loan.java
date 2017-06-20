package cl.ubb.model;

import javax.persistence.Entity;

/**
 * Created by Felipe on 6/19/2017.
 */
@Entity
public class Loan {

    private String starDate;
    private String dueDate;
    private String returnDate;

    private Borrower borrower;
    private Copy copy;

    public Loan() {
    }

    public Loan(String starDate, String dueDate, String returnDate, Borrower borrower, Copy copy) {
        this.starDate = starDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.borrower = borrower;
        this.copy = copy;
    }

    public String getStarDate() {
        return starDate;
    }

    public void setStarDate(String starDate) {
        this.starDate = starDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    public Copy getCopy() {
        return copy;
    }

    public void setCopy(Copy copy) {
        this.copy = copy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Loan loan = (Loan) o;

        if (starDate != null ? !starDate.equals(loan.starDate) : loan.starDate != null) return false;
        if (dueDate != null ? !dueDate.equals(loan.dueDate) : loan.dueDate != null) return false;
        if (returnDate != null ? !returnDate.equals(loan.returnDate) : loan.returnDate != null) return false;
        if (borrower != null ? !borrower.equals(loan.borrower) : loan.borrower != null) return false;
        return copy != null ? copy.equals(loan.copy) : loan.copy == null;
    }

    @Override
    public int hashCode() {
        int result = starDate != null ? starDate.hashCode() : 0;
        result = 31 * result + (dueDate != null ? dueDate.hashCode() : 0);
        result = 31 * result + (returnDate != null ? returnDate.hashCode() : 0);
        result = 31 * result + (borrower != null ? borrower.hashCode() : 0);
        result = 31 * result + (copy != null ? copy.hashCode() : 0);
        return result;
    }
}
