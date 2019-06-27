package org.clesun.exception;

/**
 * Created by clesun on 2016/10/23.
 */
public class UserException extends RuntimeException{

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserException(String message) {
        super(message);
    }
}
