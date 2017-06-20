package cl.ubb.model;

import javax.persistence.Entity;

/**
 * Created by Felipe on 6/19/2017.
 */
@Entity
public class LoanCondition {
    private int maxNumberOfUnitOfTime;
    private int maxNumberOfRenewals;
    private UnitOfTime unitOfTime;
    private String fee;
    private BorrowerCategory borrowerCategory;
    private TitleCategory titleCategory;


    public LoanCondition() {
    }

    public LoanCondition(int maxNumberOfUnitOfTime, int maxNumberOfRenewals, UnitOfTime unitOfTime, String fee) {
        this.maxNumberOfUnitOfTime = maxNumberOfUnitOfTime;
        this.maxNumberOfRenewals = maxNumberOfRenewals;
        this.unitOfTime = unitOfTime;
        this.fee = fee;
    }

    public int getMaxNumberOfUnitOfTime() {
        return maxNumberOfUnitOfTime;
    }

    public void setMaxNumberOfUnitOfTime(int maxNumberOfUnitOfTime) {
        this.maxNumberOfUnitOfTime = maxNumberOfUnitOfTime;
    }

    public int getMaxNumberOfRenewals() {
        return maxNumberOfRenewals;
    }

    public void setMaxNumberOfRenewals(int maxNumberOfRenewals) {
        this.maxNumberOfRenewals = maxNumberOfRenewals;
    }

    public UnitOfTime getUnitOfTime() {
        return unitOfTime;
    }

    public void setUnitOfTime(UnitOfTime unitOfTime) {
        this.unitOfTime = unitOfTime;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoanCondition that = (LoanCondition) o;

        if (maxNumberOfUnitOfTime != that.maxNumberOfUnitOfTime) return false;
        if (maxNumberOfRenewals != that.maxNumberOfRenewals) return false;
        if (unitOfTime != null ? !unitOfTime.equals(that.unitOfTime) : that.unitOfTime != null) return false;
        return fee != null ? fee.equals(that.fee) : that.fee == null;
    }

    @Override
    public int hashCode() {
        int result = maxNumberOfUnitOfTime;
        result = 31 * result + maxNumberOfRenewals;
        result = 31 * result + (unitOfTime != null ? unitOfTime.hashCode() : 0);
        result = 31 * result + (fee != null ? fee.hashCode() : 0);
        return result;
    }
}
