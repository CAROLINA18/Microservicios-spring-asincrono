package com.ms.cliente.cuenta.controller;

import com.ms.cliente.cuenta.dto.MovimientoDTO;
import com.ms.cliente.cuenta.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @PostMapping("/crear/{cuentaId}") // Se recibe el ID de la cuenta como parte de la URL
    public MovimientoDTO crearMovimiento(@PathVariable String cuentaId, @RequestBody MovimientoDTO movimientoDTO) {
        return movimientoService.crearMovimiento(cuentaId, movimientoDTO);
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
