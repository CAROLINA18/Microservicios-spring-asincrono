package com.ms.cliente.cliente;

import com.ms.cliente.cliente.model.Cliente;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteTest {
    @Test
    public void testCrearCliente() {
        // Arrange
        String nombre = "John Doe";
        int edad = 30;
        String id = "1";
        String genero ="Masculino";
        String email = "john@example.com";
        String estado ="Activo";
        String contraseña ="1234";
        String direccion ="KR20";
        String identificacion ="1144075";
        String telefono ="3182545";

        // Act
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setEdad(edad);
        cliente.setGenero(genero);
        cliente.setEstado(estado);
        cliente.setContraseña(contraseña);
        cliente.setDireccion(direccion);
        cliente.setIdentificacion(identificacion);
        cliente.setTelefono(telefono);

        // Assert
        assertEquals(nombre, cliente.getNombre());
        assertEquals(edad, cliente.getEdad());
        assertEquals(genero, cliente.getGenero());
        assertEquals(direccion, cliente.getDireccion());
        assertEquals(estado, cliente.getEstado());
        assertEquals(contraseña, cliente.getContraseña());
        assertEquals(identificacion, cliente.getIdentificacion());
        assertEquals(telefono, cliente.getTelefono());
    }
}
