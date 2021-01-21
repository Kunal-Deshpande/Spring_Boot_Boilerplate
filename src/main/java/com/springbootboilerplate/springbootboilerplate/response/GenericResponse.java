package com.springbootboilerplate.springbootboilerplate.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.springbootboilerplate.springbootboilerplate.util.Constants;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponse<T> {

    private Integer statusCode;

    private String message;

    private String errorCode;

    private String errorSubject;

    private List<T> genericItems;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DTO_DATE_PATTERN)
    private LocalDateTime timeStamp;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorSubject() {
        return errorSubject;
    }

    public void setErrorSubject(String errorSubject) {
        this.errorSubject = errorSubject;
    }

    public List<T> getGenericItems() {
        return genericItems;
    }

    public void setGenericItems(List<T> genericItems) {
        this.genericItems = genericItems;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
