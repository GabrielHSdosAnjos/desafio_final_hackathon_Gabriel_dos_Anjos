package br.com.orbitall.hackathon.repository;

import br.com.orbitall.hackathon.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
    // Método para buscar todas as transações de um cliente específico
    List<Transaction> findByCustomerId(UUID customerId);
}
