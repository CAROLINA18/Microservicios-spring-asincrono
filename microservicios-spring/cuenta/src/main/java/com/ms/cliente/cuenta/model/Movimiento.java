package com.ms.cliente.cuenta.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@Document(collection = "movimientos")
public class Movimiento {
    @Id
    private String id;
    private Date fecha;
    private String tipoMovimiento;
    private BigDecimal valor;
    private BigDecimal saldo;

}
