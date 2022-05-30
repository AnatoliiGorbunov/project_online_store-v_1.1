package ru.geekbrains.project_online_store.v_11.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppError {

    private int statusCode;
    private String message;

}
