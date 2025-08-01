package br.com.hotel.reservas_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "hospede")
@Data

public class Hospede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do hóspede é obrigatório")
    @Column(nullable = false)
    private String nome;

    @NotBlank(message = "O CPF não pode estar em branco")
    @Column(nullable = false, unique = true)
    private String cpf;

    @Email(message = "O e-mail deve ser válido")
    @NotBlank(message = "O e-mail não pode estar em branco")
    @Column(nullable = false, unique = true)
    private String email;

    private String telefone;
}
