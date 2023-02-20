package com.example.operationservice.Repository;

import com.example.operationservice.Entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OperationRepository extends JpaRepository<Operation , Long> {
    Optional<Operation> findOperationByPortefeuil(String portefeuil);
}
