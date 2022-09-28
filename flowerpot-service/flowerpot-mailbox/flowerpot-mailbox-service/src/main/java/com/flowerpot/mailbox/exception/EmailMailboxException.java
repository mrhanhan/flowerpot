package com.flowerpot.mailbox.exception;

/**
 * EmailMailboxException
 * 电子邮件邮箱异常
 * @author Mrhan
 * @date 2021/4/9 10:06
 */
public class EmailMailboxException extends RuntimeException{
    public EmailMailboxException() {
    }

    public EmailMailboxException(String message) {
        super(message);
    }

    public EmailMailboxException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailMailboxException(Throwable cause) {
        super(cause);
    }

    public EmailMailboxException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
