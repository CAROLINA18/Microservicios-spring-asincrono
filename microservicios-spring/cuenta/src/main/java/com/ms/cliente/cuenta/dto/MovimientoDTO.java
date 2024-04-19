package com.ms.cliente.cuenta.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class MovimientoDTO {
    private String id;
    private Date fecha;
    private String tipoMovimiento;
    private double valor;
    private double saldo;

}