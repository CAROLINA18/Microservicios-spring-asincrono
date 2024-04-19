package com.ms.cliente.cliente.controller;

import com.ms.cliente.cliente.dto.ClienteDTO;
import com.ms.cliente.cliente.service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteService;

    @PostMapping("/crear")
    public ClienteDTO crearCliente(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.crearCliente(clienteDTO);
    }

    @PutMapping("/editar/{clienteId}")
    public ClienteDTO editarCliente(@PathVariable String clienteId, @RequestBody ClienteDTO clienteDTO) {
        clienteDTO.setClienteId(clienteId); // Aseguramos que el DTO tenga el clienteId correcto
        return clienteService.editarCliente(clienteDTO);
    }

    @DeleteMapping("/eliminar/{clienteId}")
    public void eliminarCliente(@PathVariable String clienteId) {
        clienteService.eliminarCliente(clienteId);
    }

    @GetMapping("/{clienteId}")
    public Optional<ClienteDTO> obtenerClientePorId(@PathVariable String clienteId) {
        return clienteService.obtenerClientePorId(clienteId);
    }

    @GetMapping("/listar")
    public List<ClienteDTO> listarClientes() {
        return clienteService.listarClientes();
    }
}
