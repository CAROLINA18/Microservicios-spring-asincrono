package com.ms.cliente.cliente.repository;

import com.ms.cliente.cliente.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
}
