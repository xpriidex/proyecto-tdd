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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Suspension that = (Suspension) o;

        if (identifier != null ? !identifier.equals(that.identifier) : that.identifier != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (starDate != null ? !starDate.equals(that.starDate) : that.starDate != null) return false;
        if (numberOfUnitOfTime != null ? !numberOfUnitOfTime.equals(that.numberOfUnitOfTime) : that.numberOfUnitOfTime != null)
            return false;
        if (unitOfTime != null ? !unitOfTime.equals(that.unitOfTime) : that.unitOfTime != null) return false;
        return rutBorrower != null ? rutBorrower.equals(that.rutBorrower) : that.rutBorrower == null;
    }

    @Override
    public int hashCode() {
        int result = identifier != null ? identifier.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (starDate != null ? starDate.hashCode() : 0);
        result = 31 * result + (numberOfUnitOfTime != null ? numberOfUnitOfTime.hashCode() : 0);
        result = 31 * result + (unitOfTime != null ? unitOfTime.hashCode() : 0);
        result = 31 * result + (rutBorrower != null ? rutBorrower.hashCode() : 0);
        return result;
    }
}
