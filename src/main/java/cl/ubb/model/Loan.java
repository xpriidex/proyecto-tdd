package cl.ubb.model;

import javax.persistence.Entity;

/**
 * Created by Felipe on 6/19/2017.
 */
@Entity
public class Loan {

    private String identifier;
    private String startDate;
    private String endDate;
    private String returnDate;
    private String rutBorrower;
    private String idCopy;

    public Loan() {
    }

    public Loan(String identifier, String startDate, String endDate, String returnDate, String rutBorrower, String idCopy) {
        this.identifier = identifier;
        this.startDate = startDate;
        this.endDate = endDate;
        this.returnDate = returnDate;
        this.rutBorrower = rutBorrower;
        this.idCopy = idCopy;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getRutBorrower() {
        return rutBorrower;
    }

    public void setRutBorrower(String rutBorrower) {
        this.rutBorrower = rutBorrower;
    }

    public String getIdCopy() {
        return idCopy;
    }

    public void setIdCopy(String idCopy) {
        this.idCopy = idCopy;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Loan loan = (Loan) o;

        if (identifier != null ? !identifier.equals(loan.identifier) : loan.identifier != null) return false;
        if (startDate != null ? !startDate.equals(loan.startDate) : loan.startDate != null) return false;
        if (endDate != null ? !endDate.equals(loan.endDate) : loan.endDate != null) return false;
        if (returnDate != null ? !returnDate.equals(loan.returnDate) : loan.returnDate != null) return false;
        if (rutBorrower != null ? !rutBorrower.equals(loan.rutBorrower) : loan.rutBorrower != null) return false;
        return idCopy != null ? idCopy.equals(loan.idCopy) : loan.idCopy == null;
    }

    @Override
    public int hashCode() {
        int result = identifier != null ? identifier.hashCode() : 0;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (returnDate != null ? returnDate.hashCode() : 0);
        result = 31 * result + (rutBorrower != null ? rutBorrower.hashCode() : 0);
        result = 31 * result + (idCopy != null ? idCopy.hashCode() : 0);
        return result;
    }
}
