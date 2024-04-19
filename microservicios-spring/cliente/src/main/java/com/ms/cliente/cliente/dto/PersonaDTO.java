package com.ms.cliente.cliente.dto;

import lombok.Data;

@Data
public class PersonaDTO {
    private String clienteId;
    private String nombre;
    private String genero;
    private int edad;
    private String identificacion;
    private String direccion;
    private String telefono;

}
