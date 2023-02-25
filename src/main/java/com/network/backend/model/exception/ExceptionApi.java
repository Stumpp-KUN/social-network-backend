package com.network.backend.model.exception;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionApi  {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException e) {
        List<String> errors = e.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    private Map<String, List<String>> getErrorsMap(List<String> errors) {
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;
    }


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

    @ExceptionHandler(NoSuchLike.class)
    public ResponseEntity<LikeIncorrectData> handleException(NoSuchLike exception) {
        LikeIncorrectData data=new LikeIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchComment.class)
    public ResponseEntity<LikeIncorrectData> handleException(NoSuchComment exception) {
        LikeIncorrectData data=new LikeIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchPost.class)
    public ResponseEntity<LikeIncorrectData> handleException(NoSuchPost exception) {
        LikeIncorrectData data=new LikeIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchSub.class)
    public ResponseEntity<LikeIncorrectData> handleException(NoSuchSub exception) {
        LikeIncorrectData data=new LikeIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data,HttpStatus.NOT_FOUND);
    }



}
