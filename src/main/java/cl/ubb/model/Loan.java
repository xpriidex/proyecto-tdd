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

    public Loan() {
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

    public Loan(String identifier, String startDate, String endDate, String returnDate, String rutBorrower) {

        this.identifier = identifier;
        this.startDate = startDate;
        this.endDate = endDate;
        this.returnDate = returnDate;
        this.rutBorrower = rutBorrower;
    }
}
