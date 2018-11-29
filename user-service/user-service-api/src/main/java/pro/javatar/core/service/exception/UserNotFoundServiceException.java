/*
 * Copyright (c) 2018 Javatar LLC
 * All rights reserved.
 */

package pro.javatar.core.service.exception;

public class UserNotFoundServiceException extends Exception {

    public UserNotFoundServiceException() {
    }

    public UserNotFoundServiceException(String message) {
        super(message);
    }

    public UserNotFoundServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
