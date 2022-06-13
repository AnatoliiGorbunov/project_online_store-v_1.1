package ru.geekbrains.project_online_store.v_11.exceptions;

import java.util.List;
import java.util.stream.Collectors;

public class ValidateException extends RuntimeException{

    private List<String> errors;
    public ValidateException(List<String> errors) {
        super(errors.stream().collect(Collectors.joining(", ")));//берем строку и соединяем строку делимитром с ,
        this.errors = errors;
    }
}
