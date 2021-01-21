package com.springbootboilerplate.springbootboilerplate.util;

import com.springbootboilerplate.springbootboilerplate.exception.NoRecordsFoundException;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommonUtil {

    private static final Logger LOGGER = Logger.getLogger(CommonUtil.class.getName());

    /**
     * Get Stacktrace As String
     *
     * @param e
     * @return
     */
    public static String getStacktraceAsString(Exception e) {
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    /**
     * Get Timestamp
     *
     * @return
     */
    public static LocalDateTime getTimestamp() {
        return LocalDateTime.now(ZoneOffset.UTC);
    }

    /**
     * Validate And Get Entity
     *
     * @param entityOptional
     * @param errorMessage
     * @return
     * @throws NoRecordsFoundException
     */
    public static Object validateAndGetEntity(Optional entityOptional, String errorMessage)
            throws NoRecordsFoundException {
        if (entityOptional.isEmpty()) {
            LOGGER.log(Level.WARNING, errorMessage);
            throw new NoRecordsFoundException(errorMessage);
        }
        return entityOptional.get();
    }

}
