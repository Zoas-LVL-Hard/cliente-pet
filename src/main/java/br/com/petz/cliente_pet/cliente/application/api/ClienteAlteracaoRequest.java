package br.com.petz.cliente_pet.cliente.application.api;

import java.time.LocalDate;

import br.com.petz.cliente_pet.cliente.domain.Sexo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class ClienteAlteracaoRequest {
    @NotBlank
    private String nomeCompleto;
    @NotBlank
    private String celular;
    private String telefone;
    private Sexo sexo;
    @NotNull
    private LocalDate dataDeNasc;
    @NotNull
    private boolean aceitaTermos;
}
