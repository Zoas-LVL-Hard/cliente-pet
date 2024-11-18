package br.com.petz.cliente_pet.cliente.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.validator.constraints.br.CPF;

import br.com.petz.cliente_pet.cliente.application.api.ClienteAlteracaoRequest;
import br.com.petz.cliente_pet.cliente.application.api.ClienteRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    @Column(columnDefinition = "uuid", name = "idCliente", updatable = false, unique = true, nullable = false)
    private UUID idCliente;
    @NotBlank
    private String nomeCompleto;
    @NotBlank
    @Email
    @Column (unique = true)
    private String email;
    @NotBlank
    private String celular;
    private String telefone;
    @Enumerated (EnumType.STRING)
    private Sexo sexo;
    @NotNull
    private LocalDate dataDeNasc;
    @CPF
    @Column (unique = true)
    private String cpf;
    @NotNull
    private boolean aceitaTermos;

    private LocalDateTime momentoDoCadastro;
    private LocalDateTime dataHoraDaUltimaAlteracao;


    public Cliente(ClienteRequest clienteRequest) {
        this.nomeCompleto = clienteRequest.getNomeCompleto();
        this.email = clienteRequest.getEmail();
        this.celular = clienteRequest.getCelular();
        this.telefone = clienteRequest.getTelefone();
        this.sexo = clienteRequest.getSexo();
        this.dataDeNasc = clienteRequest.getDataDeNasc();
        this.cpf = clienteRequest.getCpf();
        this.aceitaTermos = clienteRequest.isAceitaTermos();
        this.momentoDoCadastro = LocalDateTime.now();
    }


    public void altera(ClienteAlteracaoRequest clienteAlteracaoRequest) {
        this.nomeCompleto = clienteAlteracaoRequest.getNomeCompleto();
        this.celular = clienteAlteracaoRequest.getCelular();
        this.telefone = clienteAlteracaoRequest.getTelefone();
        this.sexo = clienteAlteracaoRequest.getSexo();
        this.dataDeNasc = clienteAlteracaoRequest.getDataDeNasc();
        this.aceitaTermos = clienteAlteracaoRequest.isAceitaTermos();
        this.dataHoraDaUltimaAlteracao = LocalDateTime.now();
    }

}
