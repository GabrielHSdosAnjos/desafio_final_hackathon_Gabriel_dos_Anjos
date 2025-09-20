package br.com.orbitall.hackathon.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull(message = "O ID do cliente é obrigatório.")
    @Column(nullable = false)
    private UUID customerId;

    @NotNull(message = "O valor é obrigatório.")
    @Positive(message = "O valor da transação deve ser maior que zero.")
    @Column(nullable = false)
    private BigDecimal amount;

    @NotBlank(message = "O tipo do cartão é obrigatório.")
    @Pattern(regexp = "DÉBITO|CRÉDITO", message = "O tipo do cartão deve ser 'DÉBITO' ou 'CRÉDITO'.")
    @Column(nullable = false)
    private String cardType;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // Opcional, dependendo da regra de negócio para transações
    private boolean active;
}

