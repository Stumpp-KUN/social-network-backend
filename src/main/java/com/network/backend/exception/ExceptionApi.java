package com.network.backend.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionApi  {


    @ExceptionHandler(NoSuchUser.class)
    public ResponseEntity<UserIncorrectData> handleException(NoSuchUser exception) {
        UserIncorrectData data=new UserIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchMessage.class)
    public ResponseEntity<MessageIncorrectData> handleException(NoSuchMessage exception) {
        MessageIncorrectData data=new MessageIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data,HttpStatus.NOT_FOUND);
    }



}
