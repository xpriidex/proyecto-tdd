package cl.ubb.model;

/**
 * Created by Felipe Cifuentes on 11-07-2017.
 */
public class SuspensionRules {

    private String delayUnitOfTime;
    private String suspensionUnitOfTime;
    private String unitOfTime;

    public SuspensionRules() {
    }

    public SuspensionRules(String delayUnitOfTime, String suspensionUnitOfTime, String unitOfTime) {
        this.delayUnitOfTime = delayUnitOfTime;
        this.suspensionUnitOfTime = suspensionUnitOfTime;
        this.unitOfTime = unitOfTime;
    }

    public String getDelayUnitOfTime() {
        return delayUnitOfTime;
    }

    public void setDelayUnitOfTime(String delayUnitOfTime) {
        this.delayUnitOfTime = delayUnitOfTime;
    }

    public String getSuspensionUnitOfTime() {
        return suspensionUnitOfTime;
    }

    public void setSuspensionUnitOfTime(String suspensionUnitOfTime) {
        this.suspensionUnitOfTime = suspensionUnitOfTime;
    }

    public String getUnitOfTime() {
        return unitOfTime;
    }

    public void setUnitOfTime(String unitOfTime) {
        this.unitOfTime = unitOfTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SuspensionRules that = (SuspensionRules) o;

        if (delayUnitOfTime != null ? !delayUnitOfTime.equals(that.delayUnitOfTime) : that.delayUnitOfTime != null)
            return false;
        if (suspensionUnitOfTime != null ? !suspensionUnitOfTime.equals(that.suspensionUnitOfTime) : that.suspensionUnitOfTime != null)
            return false;
        return unitOfTime != null ? unitOfTime.equals(that.unitOfTime) : that.unitOfTime == null;
    }

    @Override
    public int hashCode() {
        int result = delayUnitOfTime != null ? delayUnitOfTime.hashCode() : 0;
        result = 31 * result + (suspensionUnitOfTime != null ? suspensionUnitOfTime.hashCode() : 0);
        result = 31 * result + (unitOfTime != null ? unitOfTime.hashCode() : 0);
        return result;
    }
}
