package com.ms.cliente.cuenta.service;


import com.ms.cliente.cuenta.dto.CuentaDTO;
import com.ms.cliente.cuenta.model.Cuenta;
import com.ms.cliente.cuenta.model.Movimiento;
import com.ms.cliente.cuenta.repository.CuentaRepository;
import com.ms.cliente.cuenta.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private MovimientoRepository movimientoRepository;

    public CuentaDTO crearCuenta(CuentaDTO cuentaDTO) {
        Cuenta cuenta = mapCuentaDTOToEntity(cuentaDTO);
        cuenta = cuentaRepository.save(cuenta);
        return mapEntityToCuentaDTO(cuenta);
    }

    public void crearCuentaParaCliente(String clienteId) {
        // Lógica para crear una nueva cuenta para el cliente
        Cuenta cuenta = new Cuenta();
        cuenta.setClienteId(clienteId); // Establece la relación cliente-cuenta
        // Otros atributos de la cuenta...
        cuentaRepository.save(cuenta);
    }


    public CuentaDTO actualizarCuenta(CuentaDTO cuentaDTO) {
        Cuenta cuenta = mapCuentaDTOToEntity(cuentaDTO);
        cuenta = cuentaRepository.save(cuenta);
        return mapEntityToCuentaDTO(cuenta);
    }

    public void eliminarCuenta(String id) {
        cuentaRepository.deleteById(id);
    }

    public Optional<CuentaDTO> obtenerCuentaPorId(String id) {
        Optional<Cuenta> cuentaOptional = cuentaRepository.findById(id);
        return cuentaOptional.map(this::mapEntityToCuentaDTO);
    }

    public List<CuentaDTO> listarCuentas() {
        List<Cuenta> cuentas = cuentaRepository.findAll();
        return cuentas.stream()
                .map(this::mapEntityToCuentaDTO)
                .collect(Collectors.toList());
    }

    private Cuenta mapCuentaDTOToEntity(CuentaDTO cuentaDTO) {
        Cuenta cuenta = new Cuenta();
        cuenta.setId(cuentaDTO.getId());
        cuenta.setNumeroCuenta(cuentaDTO.getNumeroCuenta());
        cuenta.setTipoCuenta(cuentaDTO.getTipoCuenta());
        cuenta.setSaldoInicial(cuentaDTO.getSaldoInicial());
        cuenta.setEstado(cuentaDTO.getEstado());
        List<Movimiento> movimientos = cuentaDTO.getMovimientos().stream()
                .map(movimientoDTO -> movimientoRepository.findById(movimientoDTO.getId()).orElse(null))
                .collect(Collectors.toList());

        cuenta.setMovimientos(movimientos);
        return cuenta;
    }

    private CuentaDTO mapEntityToCuentaDTO(Cuenta cuenta) {
        CuentaDTO cuentaDTO = new CuentaDTO();
        cuentaDTO.setId(cuenta.getId());
        cuentaDTO.setNumeroCuenta(cuenta.getNumeroCuenta());
        cuentaDTO.setTipoCuenta(cuenta.getTipoCuenta());
        cuentaDTO.setSaldoInicial(cuenta.getSaldoInicial());
        cuentaDTO.setEstado(cuenta.getEstado());

        return cuentaDTO;
    }
}
