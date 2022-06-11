package com.wqlkxj.exception;

/*
 * @Author WQL-KXJ
 * @ProjectName My-ORM
 * @PackageName com.wqlkxj.exception
 * @Date 2022/5/27 9:25
 * @Version 1.0
 */
public class PojoException extends RuntimeException {

    private static final long serialVersionUID = 115213412345317412L;

    public PojoException() {
        super();
    }

    public PojoException(String message) {
        super(message);
    }

    public PojoException(String message, Throwable cause) {
        super(message, cause);
    }

    public PojoException(Throwable cause) {
        super(cause);
    }

    protected PojoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
