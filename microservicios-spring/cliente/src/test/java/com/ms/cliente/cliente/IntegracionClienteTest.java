package com.ms.cliente.cliente;

import com.ms.cliente.cliente.dto.ClienteDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegracionClienteTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testObtenerCliente() {
        // Arrange
        String idCliente = "6623eee247070609139fd9f3";

        // Act
        ClienteDTO clienteDTO = restTemplate.getForObject("http://localhost:" + port + "/clientes/" + idCliente, ClienteDTO.class);

        // Assert
        assertEquals("ANAAAA2222", clienteDTO.getNombre());
        assertEquals("12345", clienteDTO.getTelefono());
    }
}
