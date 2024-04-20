package com.ms.cliente.cuenta.model.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
public class ErrorResponse {
    private int status;
    private String message;

    // Constructor, getters y setters
}