package com.ms.cliente.cuenta.controller;

import com.ms.cliente.cuenta.dto.ReporteEstadoCuenta;
import com.ms.cliente.cuenta.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping("/reportes")
    public ResponseEntity<List> generarReporte(@RequestParam String fechaInicio, @RequestParam String fechaFin, @RequestParam String clienteId) {
        List reporte = reporteService.generarReporte(fechaInicio, fechaFin, clienteId);
        return ResponseEntity.ok(reporte);
    }
}
