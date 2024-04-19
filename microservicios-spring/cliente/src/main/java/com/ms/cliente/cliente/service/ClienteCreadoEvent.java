package com.ms.cliente.cliente.service;

import com.ms.cliente.cliente.model.Cliente;
import org.springframework.context.ApplicationEvent;

public class ClienteCreadoEvent extends ApplicationEvent {

    private final Cliente cliente;

    public ClienteCreadoEvent(Object source, Cliente cliente) {
        super(source);
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
