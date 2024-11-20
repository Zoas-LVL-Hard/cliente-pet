package br.com.petz.cliente_pet.pet.application.api;

import java.time.LocalDate;
import java.util.UUID;

import br.com.petz.cliente_pet.pet.domain.Pet;
import br.com.petz.cliente_pet.pet.domain.Porte;
import br.com.petz.cliente_pet.pet.domain.SexoPet;
import br.com.petz.cliente_pet.pet.domain.TipoPet;
import lombok.Value;

@Value
public class PetClienteDetalheResponse {
    private UUID idPet;
    private String nomePet;
    private Porte porte;
    private TipoPet tipo;
    public String microChip;
    public String raca;
    public SexoPet sexo;
    public String pelagemCor;
    private LocalDate dataDeNasc;
    public String rga;
    public Integer peso;
    
    public PetClienteDetalheResponse(Pet pet) {
        this.idPet = pet.getIdPet();
        this.nomePet = pet.getNomePet();
        this.porte = pet.getPorte();
        this.tipo = pet.getTipo();
        this.microChip = pet.getMicroChip();
        this.raca = pet.getRaca();
        this.sexo = pet.getSexo();
        this.pelagemCor = pet.getPelagemCor();
        this.dataDeNasc = pet.getDataDeNasc();
        this.rga = pet.getRga();
        this.peso = pet.getPeso();
    }
}
