package org.clesun.exception;

/**
 * Created by clesun on 2017/5/17.
 */
@SuppressWarnings("serial")
public class FileReadException extends Exception{
    private String msg;
    public FileReadException(String msg) {
        this.msg=msg;
    }
    public FileReadException(Throwable msg) {
        this.msg=msg.getMessage();
    }
    @Override
    public String getMessage() {
        return this.msg;
    }

}
