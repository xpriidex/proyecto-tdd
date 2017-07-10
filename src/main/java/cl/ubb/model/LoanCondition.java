package cl.ubb.model;

import javax.persistence.Entity;

/**
 * Created by Felipe on 6/19/2017.
 */
@Entity
public class LoanCondition {
    private String identifier;
    private int maxNumberOfUnitOfTime;
    private int maxNumberOfRenewals;
    private UnitOfTime unitOfTime;
    private String fee;
    private String idBorrowerCategory;
    private String idTitleCategory;

    public LoanCondition() {
    }

    public LoanCondition(String identifier, int maxNumberOfUnitOfTime, int maxNumberOfRenewals, UnitOfTime unitOfTime, String fee, String idBorrowerCategory, String idTitleCategory) {
        this.identifier = identifier;
        this.maxNumberOfUnitOfTime = maxNumberOfUnitOfTime;
        this.maxNumberOfRenewals = maxNumberOfRenewals;
        this.unitOfTime = unitOfTime;
        this.fee = fee;
        this.idBorrowerCategory = idBorrowerCategory;
        this.idTitleCategory = idTitleCategory;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
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

    public String getIdBorrowerCategory() {
        return idBorrowerCategory;
    }

    public void setIdBorrowerCategory(String idBorrowerCategory) {
        this.idBorrowerCategory = idBorrowerCategory;
    }

    public String getIdTitleCategory() {
        return idTitleCategory;
    }

    public void setIdTitleCategory(String idTitleCategory) {
        this.idTitleCategory = idTitleCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoanCondition that = (LoanCondition) o;

        if (maxNumberOfUnitOfTime != that.maxNumberOfUnitOfTime) return false;
        if (maxNumberOfRenewals != that.maxNumberOfRenewals) return false;
        if (identifier != null ? !identifier.equals(that.identifier) : that.identifier != null) return false;
        if (unitOfTime != null ? !unitOfTime.equals(that.unitOfTime) : that.unitOfTime != null) return false;
        if (fee != null ? !fee.equals(that.fee) : that.fee != null) return false;
        if (idBorrowerCategory != null ? !idBorrowerCategory.equals(that.idBorrowerCategory) : that.idBorrowerCategory != null)
            return false;
        return idTitleCategory != null ? idTitleCategory.equals(that.idTitleCategory) : that.idTitleCategory == null;
    }

    @Override
    public int hashCode() {
        int result = identifier != null ? identifier.hashCode() : 0;
        result = 31 * result + maxNumberOfUnitOfTime;
        result = 31 * result + maxNumberOfRenewals;
        result = 31 * result + (unitOfTime != null ? unitOfTime.hashCode() : 0);
        result = 31 * result + (fee != null ? fee.hashCode() : 0);
        result = 31 * result + (idBorrowerCategory != null ? idBorrowerCategory.hashCode() : 0);
        result = 31 * result + (idTitleCategory != null ? idTitleCategory.hashCode() : 0);
        return result;
    }
}

