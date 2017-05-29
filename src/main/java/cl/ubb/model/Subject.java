package cl.ubb.model;

/**
 * Created by Felipe on 5/22/2017.
 */
public class Subject {

    private long identifier;
    private String name;

    public Subject() {
    }

    public Subject(long identifier, String name) {
        this.identifier = identifier;
        this.name = name;
    }

    public long getIdentifier() {
        return identifier;
    }

    public void setIdentifier(long identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        if (identifier != subject.identifier) return false;
        return name != null ? name.equals(subject.name) : subject.name == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (identifier ^ (identifier >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
