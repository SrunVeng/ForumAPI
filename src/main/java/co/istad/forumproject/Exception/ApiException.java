package co.istad.forumproject.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;


// Handle validation
@RestControllerAdvice
public class ApiException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ErrorResponse<?> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        List<Map<String, String>> ErrorDetailResponse = new ArrayList<>();
        Map<String, String> errorDetail = new HashMap<>();
        e.getFieldErrors().forEach(fieldError -> {
            errorDetail.put("fieldError", fieldError.getField());
            errorDetail.put("Reason", fieldError.getDefaultMessage());
            errorDetail.put("RejectedValue", Objects.requireNonNull(fieldError.getRejectedValue()).toString());
            ErrorDetailResponse.add(errorDetail);
        });
        ErrorDetailsResponse<?> errorDetailsResponse = ErrorDetailsResponse.builder()
                .code(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .title(e.getTitleMessageCode())
                .details(ErrorDetailResponse)
                .build();

        return ErrorResponse.builder()
                .error(errorDetailsResponse)
                .build();
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ResponseStatusException.class)
    ErrorResponse<?> handleMethodRuntimeException(ResponseStatusException e) {


        ErrorDetailsResponse<?> errorDetailsResponse = ErrorDetailsResponse.builder()
                .code(e.getTitleMessageCode())
                .title(e.getMessage())
                .details(e.getDetailMessageCode())
                .build();

        return ErrorResponse.builder()
                .error(errorDetailsResponse)
                .build();
    }

}
