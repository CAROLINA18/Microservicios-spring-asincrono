package com.ms.cliente.cuenta.repository;

import com.ms.cliente.cuenta.model.Cuenta;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface CuentaRepository extends MongoRepository<Cuenta, String> {
    List<Cuenta> findByClienteId(String clienteId);
}
