package com.ms.cliente.cliente.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "cliente")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente extends Persona {
    private String contraseña;
    private String estado;

}
