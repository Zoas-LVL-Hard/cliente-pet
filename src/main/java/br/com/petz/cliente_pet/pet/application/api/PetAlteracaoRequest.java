package br.com.petz.cliente_pet.pet.application.api;

import java.time.LocalDate;

import br.com.petz.cliente_pet.pet.domain.Porte;
import br.com.petz.cliente_pet.pet.domain.SexoPet;
import br.com.petz.cliente_pet.pet.domain.TipoPet;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class PetAlteracaoRequest {
    @NotBlank
    private String nomePet;
    private Porte porte;
    @NotNull
    private TipoPet tipo;
    public String microChip;
    @NotBlank
    public String raca;
    @NotNull
    public SexoPet sexo;
    public String pelagemCor;
    @NotNull
    private LocalDate dataDeNasc;
    public String rga;
    public Integer peso;
}
