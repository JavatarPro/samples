/*
 * Copyright (c) 2018 Javatar LLC
 * All rights reserved.
 */

package pro.javatar.core.exception;

import org.springframework.http.HttpStatus;

public class NotFoundRestException extends RestException {

    public static final String ERROR_CODE = "404_NotFoundRestException";

    private void initialize() {
        withCode(ERROR_CODE);
        withStatus(HttpStatus.NOT_FOUND);
    }

    public NotFoundRestException(String message) {
        super(message);
        initialize();
    }
    
    public NotFoundRestException() {
        initialize();
    }
}
