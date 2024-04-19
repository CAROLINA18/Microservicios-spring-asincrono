package com.ms.cliente.cliente.service;

import com.ms.cliente.cliente.dto.ClienteDTO;
import com.ms.cliente.cliente.model.Cliente;
import com.ms.cliente.cliente.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.ApplicationEventPublisher;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ApplicationEventPublisher eventPublisher;
    public ClienteDTO crearCliente(ClienteDTO clienteDTO) {
        Cliente cliente = mapClienteDTOToEntity(clienteDTO);
        cliente = clienteRepository.save(cliente);
        // Emite un evento de creación de cliente
        eventPublisher.publishEvent(new ClienteCreadoEvent(this , cliente));
        return mapEntityToClienteDTO(cliente);
    }

    public ClienteDTO editarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = mapClienteDTOToEntity(clienteDTO);
        cliente = clienteRepository.save(cliente);
        return mapEntityToClienteDTO(cliente);
    }

    public void eliminarCliente(String clienteId) {
        clienteRepository.deleteById(clienteId);
    }

    public Optional<ClienteDTO> obtenerClientePorId(String clienteId) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(clienteId);
        return clienteOptional.map(this::mapEntityToClienteDTO);
    }

    public List<ClienteDTO> listarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(this::mapEntityToClienteDTO)
                .collect(Collectors.toList());
    }

    private Cliente mapClienteDTOToEntity(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setClienteId(clienteDTO.getClienteId());
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setGenero(clienteDTO.getGenero());
        cliente.setEdad(clienteDTO.getEdad());
        cliente.setIdentificacion(clienteDTO.getIdentificacion());
        cliente.setDireccion(clienteDTO.getDireccion());
        cliente.setTelefono(clienteDTO.getTelefono());
        cliente.setContraseña(clienteDTO.getContraseña());
        cliente.setEstado(clienteDTO.getEstado());
        return cliente;
    }

    private ClienteDTO mapEntityToClienteDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setClienteId(cliente.getClienteId());
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setGenero(cliente.getGenero());
        clienteDTO.setEdad(cliente.getEdad());
        clienteDTO.setIdentificacion(cliente.getIdentificacion());
        clienteDTO.setDireccion(cliente.getDireccion());
        clienteDTO.setTelefono(cliente.getTelefono());
        clienteDTO.setContraseña(cliente.getContraseña());
        clienteDTO.setEstado(cliente.getEstado());
        return clienteDTO;
    }

    @Override
    public ClienteDTO obtenerCliente(String clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElse(null);
        return mapEntityToClienteDTO(cliente);
    }
}

