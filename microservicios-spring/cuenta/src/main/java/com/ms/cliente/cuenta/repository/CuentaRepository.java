package com.ms.cliente.cuenta.repository;

import com.ms.cliente.cuenta.model.Cuenta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CuentaRepository extends MongoRepository<Cuenta, String> {
}
