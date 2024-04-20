package com.ms.cliente.cuenta.dto;

import com.ms.cliente.cuenta.model.Cuenta;
import com.ms.cliente.cuenta.model.Movimiento;
import lombok.Data;

import java.util.List;

@Data
public class ReporteEstadoCuenta {
    private List<Cuenta> cuentas;
    private List<Movimiento> movimientos;

    // Constructor, getters y setters
}
