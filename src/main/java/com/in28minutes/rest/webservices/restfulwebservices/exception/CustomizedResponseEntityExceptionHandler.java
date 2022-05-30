/**
 * Controls all Exception Handling for all Exceptions thrown.
 * Create customized Exception Messages for different resources.
 *
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
package com.in28minutes.rest.webservices.restfulwebservices.exception;

import com.in28minutes.rest.webservices.restfulwebservices.user.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions
            (Exception ex, WebRequest request) throws Exception {
        // return Date, Message, Details inside of a ExceptionResponse
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleAllExceptions
            (UserNotFoundException ex, WebRequest request) throws Exception {
        // return Date, Message, Details inside of a ExceptionResponse
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
