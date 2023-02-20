package com.example.operationservice.Service;

import com.example.operationservice.Entity.Operation;

import java.util.Optional;

public interface OperationService {

    public Operation passerOperation(Operation operation);

    public Optional<Operation> findOperationByPortefeuil(String portefeuil);
}
