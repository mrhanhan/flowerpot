package com.flowerpot.common.utils;

/**
 * AssetException
 *
 * @author Mrhan
 * @date 2021/3/24 14:34
 */
public class AssetException extends RuntimeException {
    public AssetException() {
    }

    public AssetException(String message) {
        super(message);
    }

    public AssetException(String message, Throwable cause) {
        super(message, cause);
    }

    public AssetException(Throwable cause) {
        super(cause);
    }

    public AssetException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
