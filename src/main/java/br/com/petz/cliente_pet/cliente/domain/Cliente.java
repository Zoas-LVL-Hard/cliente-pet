package br.com.petz.cliente_pet.cliente.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

// Senha não faz parte dessa regra de negocios, normalmente ela faz parte da regra de ALTENTICAÇÃO.
// Na criação de algo ((Cliente)) é necessário o uso de um construtor vazio ou a anotação @NoArgsConstructor, pois dessa forma o cliente é criado com os atributos,
// caso contrario seria um cliente vazio(sem atributos).
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Data
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID idCliente;
    @NotBlank
    private String nomeCompleto;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String celular;
    private String telefone;
    private Sexo sexo;
    @NotNull
    private LocalDate dataDeNasc;
    @CPF
    private String cpf;
    @NotNull
    private boolean aceitaTermos;

    private LocalDateTime momentoDoCadastro;
    private LocalDateTime dataHoraDaUltimaAlteracao;

    public Cliente(@NotBlank String nomeCompleto, @NotBlank @Email String email, @NotBlank String celular,
            String telefone, Sexo sexo, @NotNull LocalDate dataDeNasc, @CPF String cpf,
            @NotNull boolean aceitaTermos) {
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.celular = celular;
        this.telefone = telefone;
        this.sexo = sexo;
        this.dataDeNasc = dataDeNasc;
        this.cpf = cpf;
        this.aceitaTermos = aceitaTermos;
        this.momentoDoCadastro = LocalDateTime.now();
    }

}
