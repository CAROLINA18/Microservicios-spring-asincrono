package com.ms.cliente.cuenta.service;

import com.ms.cliente.cuenta.dto.ReporteEstadoCuenta;
import com.ms.cliente.cuenta.model.Cuenta;
import com.ms.cliente.cuenta.model.Movimiento;
import com.ms.cliente.cuenta.repository.CuentaRepository;
import com.ms.cliente.cuenta.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReporteService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private MovimientoRepository movimientoRepository;

    public List<Cuenta> generarReporte(String fechaInicio, String fechaFin, String clienteId) {
        List<Cuenta> cuentas = cuentaRepository.findByClienteId(clienteId);
        for (Cuenta cuenta : cuentas) {
            BigDecimal saldo = BigDecimal.ZERO;
            for (Movimiento movimiento : cuenta.getMovimientos()) {
                // Sumar o restar el valor del movimiento al saldo
                if (movimiento.getTipoMovimiento().equals("R")) {
                    saldo = saldo.subtract(movimiento.getValor());
                } else if (movimiento.getTipoMovimiento().equals("C")) {
                    saldo = saldo.add(movimiento.getValor());
                }
            }
            // Establecer el saldo calculado en la cuenta
            cuenta.setSaldoInicial(saldo);
        }
        return cuentas;
    }
}
