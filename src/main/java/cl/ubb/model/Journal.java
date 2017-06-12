package cl.ubb.model;

import javax.persistence.Entity;

/**
 * Created by Felipe Cifuentes on 05-06-2017.
 */
@Entity
public class Journal extends Title {
    private String volumen;
    private String isbn;
    private String issue;

    public Journal() {
    }

    public Journal(String identifier, String name, String year, String format, String replacementCost, Subject subject, String volumen, String isbn, String issue) {
        super(identifier, name, year, format, replacementCost, subject);
        this.volumen = volumen;
        this.isbn = isbn;
        this.issue = issue;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        issue = issue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Journal journal = (Journal) o;

        if (volumen != null ? !volumen.equals(journal.volumen) : journal.volumen != null) return false;
        if (isbn != null ? !isbn.equals(journal.isbn) : journal.isbn != null) return false;
        return issue != null ? issue.equals(journal.issue) : journal.issue == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (volumen != null ? volumen.hashCode() : 0);
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + (issue != null ? issue.hashCode() : 0);
        return result;
    }
}
