package com.caitiezhu.gaea.gitlab.exception;

public class EmptyArgsException extends Exception {

    public EmptyArgsException() {
        super();
    }

    public EmptyArgsException(String message) {
        super(message);
    }

    public EmptyArgsException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyArgsException(Throwable cause) {
        super(cause);
    }
}
