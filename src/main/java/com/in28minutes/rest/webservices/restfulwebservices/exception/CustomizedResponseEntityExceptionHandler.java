package com.in28minutes.rest.webservices.restfulwebservices.exception;

import com.in28minutes.rest.webservices.restfulwebservices.user.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

/**
 * A controller advice allows you to use exactly the same exception handling techniques but apply them across the whole application, not just to an individual controller. You can think of them as an annotation driven interceptor.
 *
 * Any class annotated with @ControllerAdvice becomes a controller-advice and three types of method are supported:
 *
 * Exception handling methods annotated with @ExceptionHandler.
 * Model enhancement methods (for adding additional data to the model) annotated with
 * @ModelAttribute. Note that these attributes are not available to the exception handling views.
 * Binder initialization methods (used for configuring form-handling) annotated with
 * @InitBinder.
 */

@ControllerAdvice
@RestController
public class StandardizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions (UserNotFoundException ex, WebRequest request) {
        // return Date, Message, Details inside of a ExceptionResponse
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), new ex.getMessage(), new ex.getDescription(false));
    }
}
