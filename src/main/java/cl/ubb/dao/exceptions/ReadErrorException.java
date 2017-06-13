package cl.ubb.dao.exceptions;

/**
 * Created by Felipe on 5/29/2017.
 */
public class ReadErrorException extends Throwable {

    public ReadErrorException(String message) {
        super(message);
    }

    public ReadErrorException() {
    }
}
