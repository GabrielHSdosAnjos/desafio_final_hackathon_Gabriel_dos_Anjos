package br.com.orbitall.hackathon.service;

import br.com.orbitall.hackathon.model.Transaction;
import br.com.orbitall.hackathon.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CustomerService customerService;

    public Transaction create(Transaction transaction) {
        customerService.findById(transaction.getCustomerId());

        transaction.setCreatedAt(LocalDateTime.now());
        transaction.setActive(true);
        return transactionRepository.save(transaction);
    }

    public List<Transaction> findByCustomerId(UUID customerId) {
        customerService.findById(customerId);
        return transactionRepository.findByCustomerId(customerId);
    }
}

