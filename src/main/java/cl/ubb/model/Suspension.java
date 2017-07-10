package cl.ubb.model;

import javax.persistence.Entity;

/**
 * Created by Felipe Cifuentes on 29-05-2017.
 */
@Entity
public class Suspension {
    private String identifier;
    private String description;
    private String starDate;
    private String numberOfUnitOfTime;
    private String unitOfTime;
    private String rutBorrower;

    public Suspension() {
    }

    public Suspension(String identifier, String description, String starDate, String numberOfUnitOfTime, String unitOfTime, String rutBorrower) {
        this.identifier = identifier;
        this.description = description;
        this.starDate = starDate;
        this.numberOfUnitOfTime = numberOfUnitOfTime;
        this.unitOfTime = unitOfTime;
        this.rutBorrower = rutBorrower;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStarDate() {
        return starDate;
    }

    public void setStarDate(String starDate) {
        this.starDate = starDate;
    }

    public String getNumberOfUnitOfTime() {
        return numberOfUnitOfTime;
    }

    public void setNumberOfUnitOfTime(String numberOfUnitOfTime) {
        this.numberOfUnitOfTime = numberOfUnitOfTime;
    }

    public String getUnitOfTime() {
        return unitOfTime;
    }

    public void setUnitOfTime(String unitOfTime) {
        this.unitOfTime = unitOfTime;
    }

    public String getRutBorrower() {
        return rutBorrower;
    }

    public void setRutBorrower(String rutBorrower) {
        this.rutBorrower = rutBorrower;
    }
}
