package ru.geekbrains.project_online_store.v_11.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FieldValidationException {
    private List<String> errorFieldMessage;

    public FieldValidationException(List<String> errors){
        this.errorFieldMessage = errors;
    }
}
