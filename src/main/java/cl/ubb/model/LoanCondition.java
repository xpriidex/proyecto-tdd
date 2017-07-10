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
}

