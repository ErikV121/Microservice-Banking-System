package com.ErikV121.account_service.constants;

public class HttpConstants {
    private HttpConstants() {
    }

    // Success responses
    public static final String STATUS_OK = "200";
    public static final String MESSAGE_OK = "Request processed successfully";

    public static final String STATUS_CREATED = "201";
    public static final String MESSAGE_CREATED = "Resource created successfully";


    // Client error responses
    public static final String STATUS_BAD_REQUEST = "400";
    public static final String MESSAGE_BAD_REQUEST = "Invalid request parameters";

    public static final String STATUS_UNAUTHORIZED = "401";
    public static final String MESSAGE_UNAUTHORIZED = "Authentication required";

    public static final String STATUS_FORBIDDEN = "403";
    public static final String MESSAGE_FORBIDDEN = "Access denied to requested resource";

    public static final String STATUS_NOT_FOUND = "404";
    public static final String MESSAGE_NOT_FOUND = "Requested resource not found";

    // Server error responses
    public static final String STATUS_SERVER_ERROR = "500";
    public static final String MESSAGE_SERVER_ERROR = "An internal server error occurred";

    public static final String STATUS_SERVICE_UNAVAILABLE = "503";
    public static final String MESSAGE_SERVICE_UNAVAILABLE = "Service temporarily unavailable";
}