package com.ms.cliente.cliente.service;

import com.ms.cliente.cuenta.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ClienteCreadoListener {

    @Autowired
    private CuentaService cuentaService;

    @EventListener
    public void handleClienteCreadoEvent(ClienteCreadoEvent event) {
        // Cuando se recibe el evento de creación de cliente, se crea una nueva cuenta para el cliente correspondiente
        cuentaService.crearCuentaParaCliente(event.getCliente().getClienteId());
    }
}
