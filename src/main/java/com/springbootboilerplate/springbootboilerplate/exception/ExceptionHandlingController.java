package com.springbootboilerplate.springbootboilerplate.exception;

import com.springbootboilerplate.springbootboilerplate.response.GenericResponse;
import com.springbootboilerplate.springbootboilerplate.util.CommonUtil;
import com.springbootboilerplate.springbootboilerplate.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Level;
import java.util.logging.Logger;

@ControllerAdvice
public class ExceptionHandlingController extends ResponseEntityExceptionHandler {

    private final Logger LOGGER = Logger.getLogger(ExceptionHandlingController.class.getName());

    @Autowired
    private HttpServletRequest request;

    /**
     * No Records Found Exception
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = {NoRecordsFoundException.class})
    public ResponseEntity<GenericResponse<NoRecordsFoundException>> handleNoRecordsFoundException(
            NoRecordsFoundException e) {
        GenericResponse<NoRecordsFoundException> genericResponse = new GenericResponse<>();
        genericResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        genericResponse.setMessage(e.getMessage());
        genericResponse.setTimeStamp(CommonUtil.getTimestamp());

        logRequestInfo(Level.WARNING, CommonUtil.getStacktraceAsString(e));

        return new ResponseEntity<>(genericResponse, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    /**
     * Validation Error Exception
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = {ValidationErrorException.class})
    public ResponseEntity<GenericResponse<ValidationErrorException>> handleValidationErrorException(
            ValidationErrorException e) {
        GenericResponse<ValidationErrorException> genericResponse = new GenericResponse<>();
        genericResponse.setStatusCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
        genericResponse.setMessage(e.getMessage());
        genericResponse.setTimeStamp(CommonUtil.getTimestamp());

        logRequestInfo(Level.WARNING, CommonUtil.getStacktraceAsString(e));

        return new ResponseEntity<>(genericResponse, new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    /**
     * Username Not Found Exception
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = {TimeOutException.class})
    public ResponseEntity<GenericResponse<TimeOutException>> handleTimeOutException(TimeOutException e) {
        GenericResponse<TimeOutException> genericResponse = new GenericResponse<>();
        genericResponse.setStatusCode(HttpStatus.REQUEST_TIMEOUT.value());
        genericResponse.setMessage(e.getMessage());
        genericResponse.setTimeStamp(CommonUtil.getTimestamp());

        logRequestInfo(Level.WARNING, CommonUtil.getStacktraceAsString(e));

        return new ResponseEntity<>(genericResponse, new HttpHeaders(), HttpStatus.REQUEST_TIMEOUT);
    }

    /**
     * Exception
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<GenericResponse<Exception>> handleException(Exception e) {
        GenericResponse<Exception> genericResponse = new GenericResponse<>();
        genericResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        genericResponse.setMessage(Constants.INTERNAL_SERVER_ERROR_MESSAGE);
        genericResponse.setTimeStamp(CommonUtil.getTimestamp());

        logRequestInfo(Level.SEVERE, CommonUtil.getStacktraceAsString(e));

        return new ResponseEntity<>(genericResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private void logRequestInfo(Level level, String errorString) {
        if (request != null && request.getAttribute("requestId") != null) {
            LOGGER.log(level, "RequestId: " + request.getAttribute("requestId") + " " + errorString);
        } else {
            LOGGER.log(Level.WARNING, "RequestId Is Null");
        }
    }

}
