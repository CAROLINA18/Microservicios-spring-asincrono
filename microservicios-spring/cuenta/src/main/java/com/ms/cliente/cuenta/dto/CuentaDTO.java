package com.ms.cliente.cuenta.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data

public class CuentaDTO {
    private String id;
    private String numeroCuenta;
    private String tipoCuenta;
    private BigDecimal saldoInicial;
    private String estado;
    private String clienteId;
    private List<MovimientoDTO> movimientos;
    public CuentaDTO() {
        this.movimientos = new ArrayList<>();
    }
}
