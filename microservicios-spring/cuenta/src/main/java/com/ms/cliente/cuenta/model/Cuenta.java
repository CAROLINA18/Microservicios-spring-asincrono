package com.ms.cliente.cuenta.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "cuentas")
public class Cuenta {
    @Id
    private String id;
    private String numeroCuenta;
    private String tipoCuenta;
    private BigDecimal saldoInicial;
    private String estado;
    private String clienteId;
    @DBRef
    private List<Movimiento> movimientos;

    public Cuenta() {
        this.movimientos = new ArrayList<>();
    }

}
