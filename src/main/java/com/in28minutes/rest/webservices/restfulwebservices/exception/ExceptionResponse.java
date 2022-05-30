package com.in28minutes.rest.webservices.restfulwebservices.exception;

import java.util.Date;

public class ExceptionResponse {
    // The most basic properties of an exception are:
    // date
    private Date timestamp;
    // message
    private String message;

    // details
    private String details;

    /**
     * A standardized Exception Response to be used across an entire enterprise application.
     * Users get a uniform Response which they can grow accustomed to.
     * @param timestamp timestamp of the ExceptionResponse
     * @param message message of the ExceptionResponse
     * @param details details of the ExceptionResponse
     */
    public ExceptionResponse(Date timestamp, String message, String details) {

        /**
         * @TODO Ideally, map an FN() to a ROUTE that renders a template for XXX HTTP Code.
         * Developers want to have a uniform Response for certain HTTP Response codes.
         * Developers also must make sure to hide the implementation details of their
         */
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    /**
     * Get the timestamp of the ExceptionResponse
     * @return java.util.Date - A specific instant in time, with millisecond precision
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * Get the message of the ExceptionResponse
     * @return String - The message of the ExceptionResponse
     */
    public String getMessage() {
        return message;
    }

    /**
     * Get the details of the ExceptionResponse
     * @return String Details of the ExceptionResponse
     */
    public String getDetails() {
        return details;
    }

}
