package com.ms.cliente.cuenta.controller;

import com.ms.cliente.cuenta.dto.MovimientoDTO;
import com.ms.cliente.cuenta.model.exception.ErrorResponse;
import com.ms.cliente.cuenta.model.exception.MovimientoInvalidoException;
import com.ms.cliente.cuenta.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @PostMapping("/crear/{cuentaId}")
    public ResponseEntity<?> crearMovimiento(@PathVariable String cuentaId, @RequestBody MovimientoDTO movimientoDTO) {
        try {

            MovimientoDTO movimientoCreado = movimientoService.crearMovimiento(cuentaId, movimientoDTO);
            return ResponseEntity.ok(movimientoCreado);
        } catch (MovimientoInvalidoException e) {

            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);

        }
    }

    @PutMapping("/editar")
    public MovimientoDTO editarMovimiento(@RequestBody MovimientoDTO movimientoDTO) {
        return movimientoService.actualizarMovimiento(movimientoDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarMovimiento(@PathVariable String id) {
        movimientoService.eliminarMovimiento(id);
    }

    @GetMapping("/{id}")
    public Optional<MovimientoDTO> obtenerMovimientoPorId(@PathVariable String id) {
        return movimientoService.obtenerMovimientoPorId(id);
    }

    @GetMapping("/listar")
    public List<MovimientoDTO> listarMovimientos() {
        return movimientoService.listarMovimientos();
    }
}
