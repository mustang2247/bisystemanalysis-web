package com.bitop.web.bisystemanalysisweb.model.sysmodel.exception;


public class FormRepeatException extends RuntimeException {

    public FormRepeatException(String message){ super(message);}

    public FormRepeatException(String message, Throwable cause){ super(message, cause);}
}
