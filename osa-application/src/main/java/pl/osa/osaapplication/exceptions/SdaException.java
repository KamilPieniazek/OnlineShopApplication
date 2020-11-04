package pl.osa.osaapplication.exceptions;

public class SdaException extends RuntimeException {
    public SdaException() {
        super();
    }

    public SdaException(final String message) {
        super(message);
    }

    public SdaException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public SdaException(final Throwable cause) {
        super(cause);
    }

    protected SdaException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
