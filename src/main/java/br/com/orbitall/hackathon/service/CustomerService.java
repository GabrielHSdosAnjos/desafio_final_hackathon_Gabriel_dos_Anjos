package br.com.orbitall.hackathon.service;
import br.com.orbitall.hackathon.handlers.ResourceNotFoundException;
import br.com.orbitall.hackathon.model.Customer;
import br.com.orbitall.hackathon.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer create(Customer customer) {
        customer.setCreatedAt(LocalDateTime.now());
        customer.setUpdatedAt(LocalDateTime.now());
        customer.setActive(true);
        return customerRepository.save(customer);
    }

    public Customer findById(UUID id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com o ID: " + id));
    }

    public List<Customer> findAllActive() {
        return customerRepository.findAllByActiveTrue();
    }

    public Customer update(UUID id, Customer customerDetails) {
        Customer customer = findById(id);
        customer.setFullName(customerDetails.getFullName());
        customer.setEmail(customerDetails.getEmail());
        customer.setPhone(customerDetails.getPhone());
        customer.setUpdatedAt(LocalDateTime.now());
        return customerRepository.save(customer);
    }

    public void delete(UUID id) {
        Customer customer = findById(id);
        // Soft delete: Apenas inativa o cliente
        customer.setActive(false);
        customer.setUpdatedAt(LocalDateTime.now());
        customerRepository.save(customer);
    }
}


