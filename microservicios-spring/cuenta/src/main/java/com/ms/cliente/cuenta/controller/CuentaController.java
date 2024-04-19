package com.ms.cliente.cuenta.controller;

import com.ms.cliente.cuenta.dto.CuentaDTO;
import com.ms.cliente.cuenta.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

   @PostMapping("/crear")
    public CuentaDTO crearCuenta(@RequestBody CuentaDTO cuentaDTO) {
        return cuentaService.crearCuenta(cuentaDTO);
    }

    @PutMapping("/editar/{cuentaId}")
    public CuentaDTO editarCuenta(@PathVariable String cuentaId, @RequestBody CuentaDTO cuentaDTO) {
        cuentaDTO.setId(cuentaId);
        return cuentaService.actualizarCuenta(cuentaDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarCuenta(@PathVariable String id) {
        cuentaService.eliminarCuenta(id);
    }

    @GetMapping("/{id}")
    public Optional<CuentaDTO> obtenerCuentaPorId(@PathVariable String id) {
        return cuentaService.obtenerCuentaPorId(id);
    }

    @GetMapping("/listar")
    public List<CuentaDTO> listarCuentas() {
        return cuentaService.listarCuentas();
    }
}
