package org.clesun.exception;

/**
 * Created by clesun on 2017/5/17.
 */
@SuppressWarnings("serial")
public class ServiceException extends Exception {
    private String msg;
    public ServiceException(String msg) {
        this.msg=msg;
    }
    public ServiceException(Throwable msg) {
        this.msg=msg.getMessage();
    }
    @Override
    public String getMessage() {
        return this.msg;
    }
}

