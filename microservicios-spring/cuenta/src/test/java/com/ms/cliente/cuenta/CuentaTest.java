package com.ms.cliente.cuenta;

import com.ms.cliente.cuenta.model.Cuenta;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CuentaTest {
    @Test
    public void testCrearCliente() {
        // Arrange
        String numeroCuenta = "12345";
        String tipoCuenta = "R";
        BigDecimal saldoInicial = new BigDecimal(1);
        String estado ="activo";
        String clienteId = "12we34rtrt";

        // Act
        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCuenta(numeroCuenta);
        cuenta.setTipoCuenta(tipoCuenta);
        cuenta.setSaldoInicial(new BigDecimal(String.valueOf(saldoInicial)));
        cuenta.setEstado(estado);
        cuenta.setClienteId(clienteId);


        // Assert
        assertEquals(numeroCuenta, cuenta.getNumeroCuenta());
        assertEquals(tipoCuenta, cuenta.getTipoCuenta());
        assertEquals(saldoInicial, cuenta.getSaldoInicial());
        assertEquals(estado, cuenta.getEstado());
        assertEquals(clienteId, cuenta.getClienteId());

    }
}
