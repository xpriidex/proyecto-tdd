package cl.ubb.model;

import javax.persistence.Entity;
import java.util.LinkedList;

/**
 * Created by Felipe Cifuentes on 22-05-2017.
 */
@Entity
public class Borrower {

    private String rut;
    private String name;
    private String cellPhone;
    private String email;
    private BorrowerCategory borrowerCategory;
    private LinkedList <Suspension> suspensions;
    private LinkedList <Loan> loans;

    public Borrower() {
    }

    public Borrower(String rut, String name, String cellPhone, String email, BorrowerCategory borrowerCategory, LinkedList<Suspension> suspensions, LinkedList<Loan> loans) {
        this.rut = rut;
        this.name = name;
        this.cellPhone = cellPhone;
        this.email = email;
        this.borrowerCategory = borrowerCategory;
        this.suspensions = suspensions;
        this.loans = loans;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BorrowerCategory getBorrowerCategory() {
        return borrowerCategory;
    }

    public void setBorrowerCategory(BorrowerCategory borrowerCategory) {
        this.borrowerCategory = borrowerCategory;
    }

    public LinkedList<Suspension> getSuspensions() {
        return suspensions;
    }

    public void setSuspensions(LinkedList<Suspension> suspensions) {
        this.suspensions = suspensions;
    }

    public LinkedList<Loan> getLoans() {
        return loans;
    }

    public void setLoans(LinkedList<Loan> loans) {
        this.loans = loans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Borrower borrower = (Borrower) o;

        if (rut != null ? !rut.equals(borrower.rut) : borrower.rut != null) return false;
        if (name != null ? !name.equals(borrower.name) : borrower.name != null) return false;
        if (cellPhone != null ? !cellPhone.equals(borrower.cellPhone) : borrower.cellPhone != null) return false;
        if (email != null ? !email.equals(borrower.email) : borrower.email != null) return false;
        if (borrowerCategory != null ? !borrowerCategory.equals(borrower.borrowerCategory) : borrower.borrowerCategory != null)
            return false;
        if (suspensions != null ? !suspensions.equals(borrower.suspensions) : borrower.suspensions != null)
            return false;
        return loans != null ? loans.equals(borrower.loans) : borrower.loans == null;
    }

    @Override
    public int hashCode() {
        int result = rut != null ? rut.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (cellPhone != null ? cellPhone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (borrowerCategory != null ? borrowerCategory.hashCode() : 0);
        result = 31 * result + (suspensions != null ? suspensions.hashCode() : 0);
        result = 31 * result + (loans != null ? loans.hashCode() : 0);
        return result;
    }
}
