package br.com.petz.cliente_pet.pet.application.api;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.petz.cliente_pet.pet.domain.Pet;
import br.com.petz.cliente_pet.pet.domain.TipoPet;
import lombok.Value;

@Value
//! Aqui é convertida a lista de Pet "List <Pet>" para PetClienteListResponse, onde retorna o necessário para o front.
public class PetClienteListResponse {
    private UUID idPet;
    private String nomePet;
    private TipoPet tipo;
    public String raca;
    public String pelagemCor;
    private LocalDate dataDeNasc;

    public static List<PetClienteListResponse> converte(List<Pet> petsDoCliente) {
        return petsDoCliente.stream()
        .map(PetClienteListResponse::new)
        .collect(Collectors.toList());
    }

    public PetClienteListResponse (Pet pet){
    this.idPet = pet.getIdPet();
    this.nomePet = pet.getNomePet();
    this.tipo = pet.getTipo();
    this.raca = pet.getRaca();
    this.pelagemCor = pet.getPelagemCor();
    this.dataDeNasc = pet.getDataDeNasc();
    }

}
