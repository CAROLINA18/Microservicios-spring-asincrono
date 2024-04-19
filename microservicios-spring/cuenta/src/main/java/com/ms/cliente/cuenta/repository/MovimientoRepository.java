package com.ms.cliente.cuenta.repository;

import com.ms.cliente.cuenta.model.Movimiento;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovimientoRepository extends MongoRepository<Movimiento, String> {
}