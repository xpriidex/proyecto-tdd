package cl.ubb.dao.exceptions;

/**
 * Created by Felipe on 5/22/2017.
 */
public class EmptyListException extends Exception {
    public EmptyListException() {
    }

    public EmptyListException(String message) {
        super(message);
    }
}
