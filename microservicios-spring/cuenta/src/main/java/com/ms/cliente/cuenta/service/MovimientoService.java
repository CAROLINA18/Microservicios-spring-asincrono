package com.ms.cliente.cuenta.service;

import com.ms.cliente.cuenta.dto.MovimientoDTO;
import com.ms.cliente.cuenta.model.Cuenta;
import com.ms.cliente.cuenta.model.Movimiento;
import com.ms.cliente.cuenta.model.exception.MovimientoInvalidoException;
import com.ms.cliente.cuenta.repository.CuentaRepository;
import com.ms.cliente.cuenta.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private CuentaRepository cuentaRepository; // Repositorio de Cuenta

    public MovimientoDTO crearMovimiento(String cuentaId, MovimientoDTO movimientoDTO) {
        // Verificar si la cuenta existe
        Optional<Cuenta> cuentaOptional = cuentaRepository.findById(cuentaId);
        if (cuentaOptional.isPresent()) {
            Cuenta cuenta = cuentaOptional.get();

            // Mapear el DTO a la entidad de movimiento
            Movimiento movimiento = mapMovimientoDTOToEntity(movimientoDTO);
        if(movimiento.getValor().compareTo(movimiento.getSaldo())>0  && movimiento.getTipoMovimiento().equals("R") ){
            throw new MovimientoInvalidoException("Saldo no disponible recuerde que su saldo es " + movimiento.getSaldo());
        }
            if (movimiento.getTipoMovimiento().equals("R")) {
                movimiento.setSaldo(movimiento.getSaldo().subtract(movimiento.getValor()));

            } else if (movimiento.getTipoMovimiento().equals("C")) {
                movimiento.setSaldo(movimiento.getValor().add(movimiento.getSaldo()));
            } else {
                throw new MovimientoInvalidoException("Solo se permite C para consignacion o R para retiro");
            }

            movimientoRepository.save(movimiento);
            // Agregar el movimiento a la lista de movimientos de la cuenta
            cuenta.getMovimientos().add(movimiento);
            // Guardar la cuenta actualizada en la base de datos
            cuentaRepository.save(cuenta);
            // Retornar el movimiento creado
            return mapEntityToMovimientoDTO(movimiento);
        } else {
            throw new RuntimeException("La cuenta con el ID " + cuentaId + " no existe.");
        }
    }

    public MovimientoDTO actualizarMovimiento(MovimientoDTO movimientoDTO) {
        Movimiento movimiento = mapMovimientoDTOToEntity(movimientoDTO);
        movimiento = movimientoRepository.save(movimiento);
        return mapEntityToMovimientoDTO(movimiento);
    }

    public void eliminarMovimiento(String id) {
        movimientoRepository.deleteById(id);
    }

    public Optional<MovimientoDTO> obtenerMovimientoPorId(String id) {
        Optional<Movimiento> movimientoOptional = movimientoRepository.findById(id);
        return movimientoOptional.map(this::mapEntityToMovimientoDTO);
    }

    public List<MovimientoDTO> listarMovimientos() {
        List<Movimiento> movimientos = movimientoRepository.findAll();
        return movimientos.stream()
                .map(this::mapEntityToMovimientoDTO)
                .collect(Collectors.toList());
    }

    private Movimiento mapMovimientoDTOToEntity(MovimientoDTO movimientoDTO) {
        Movimiento movimiento = new Movimiento();
        movimiento.setId(movimientoDTO.getId());
        movimiento.setFecha(movimientoDTO.getFecha());
        movimiento.setTipoMovimiento(movimientoDTO.getTipoMovimiento());
        movimiento.setValor(movimientoDTO.getValor());
        movimiento.setSaldo(movimientoDTO.getSaldo());
        return movimiento;
    }

    private MovimientoDTO mapEntityToMovimientoDTO(Movimiento movimiento) {
        MovimientoDTO movimientoDTO = new MovimientoDTO();
        movimientoDTO.setId(movimiento.getId());
        movimientoDTO.setFecha(movimiento.getFecha());
        movimientoDTO.setTipoMovimiento(movimiento.getTipoMovimiento());
        movimientoDTO.setValor(movimiento.getValor());
        movimientoDTO.setSaldo(movimiento.getSaldo());
        return movimientoDTO;
    }
}
