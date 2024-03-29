package kr.co.sanghun.assetmanagement.api.controller;

import kr.co.sanghun.assetmanagement.api.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Slf4j
@ControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ErrorResponse exceptionHandler(MethodArgumentNotValidException e) {
        ErrorResponse response = new ErrorResponse("400", "잘못된 요청입니다.");
        List<FieldError> fieldErrors = e.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            response.addValidation(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return response;
    }
}
