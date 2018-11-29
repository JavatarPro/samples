/*
 * Copyright (c) 2018 Javatar LLC
 * All rights reserved.
 */

package pro.javatar.core.repository.exception;

public class UserNotFoundDBException extends Exception {

    public UserNotFoundDBException() {
    }

    public UserNotFoundDBException(String message) {
        super(message);
    }

    public UserNotFoundDBException(String message, Throwable cause) {
        super(message, cause);
    }
}
