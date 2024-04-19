package com.ms.cliente.cliente.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteDTO extends PersonaDTO {
    private String contraseña;
    private String estado;

}
