package com.ms.cliente.cuenta.repository;

import com.ms.cliente.cuenta.model.Movimiento;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface MovimientoRepository extends MongoRepository<Movimiento, String> {
}