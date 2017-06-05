package cl.ubb.model;

/**
 * Created by Felipe Cifuentes on 05-06-2017.
 */
public class Book extends Title {

    private String author;
    private String edition;
    private String isbn;
    private String editorial;

    public Book() {
    }

    public Book(String identifier, String name, String year, String format, String replacementCost, Subject subject, String author, String edition, String isbn, String editorial) {
        super(identifier, name, year, format, replacementCost, subject);
        this.author = author;
        this.edition = edition;
        this.isbn = isbn;
        this.editorial = editorial;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Book book = (Book) o;

        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        if (edition != null ? !edition.equals(book.edition) : book.edition != null) return false;
        if (isbn != null ? !isbn.equals(book.isbn) : book.isbn != null) return false;
        return editorial != null ? editorial.equals(book.editorial) : book.editorial == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (edition != null ? edition.hashCode() : 0);
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + (editorial != null ? editorial.hashCode() : 0);
        return result;
    }
}
