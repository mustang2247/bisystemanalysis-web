package com.bitop.web.bisystemanalysisweb.model.sysmodel.exception;

public class HttpServletException extends RuntimeException {

    public HttpServletException(String message){
        super(message);
    }

    public HttpServletException(String message, Throwable cause){
        super(message, cause);
    }
}
