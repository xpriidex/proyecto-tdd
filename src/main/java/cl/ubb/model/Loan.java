package cl.ubb.model;

import javax.persistence.Entity;

/**
 * Created by Felipe on 6/19/2017.
 */
@Entity
public class Loan {

    private String startDate;
    private String endDate;
    private String returnDate;
    private String rutBorrower;

    public Loan() {
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate(){
        return endDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setStartDate(String startDate){
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public void setRutBorrower(String rutBorrower) {
        this.rutBorrower = rutBorrower;
    }

    public String getRutBorrower() {
        return rutBorrower;
    }
}
