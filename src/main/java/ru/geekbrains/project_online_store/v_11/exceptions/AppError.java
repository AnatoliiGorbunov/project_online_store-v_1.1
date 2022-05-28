package ru.geekbrains.project_online_store.v_11.exceptions;

import lombok.Data;

@Data
public class AppError {

    private int statusCode;
    private String message;

    public AppError(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public AppError() {
    }
}
