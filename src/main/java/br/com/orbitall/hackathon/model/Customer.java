package br.com.orbitall.hackathon.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "O nome completo é obrigatório.")
    @Size(max = 255, message = "O nome completo não pode exceder 255 caracteres.")
    @Column(nullable = false, length = 255)
    private String fullName;

    @NotBlank(message = "O e-mail é obrigatório.")
    @Email(message = "Formato de e-mail inválido.")
    @Size(max = 100, message = "O e-mail não pode exceder 100 caracteres.")
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @NotBlank(message = "O telefone é obrigatório.")
    @Column(nullable = false)
    private String phone;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private boolean active;
}