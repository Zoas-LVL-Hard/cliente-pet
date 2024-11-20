package br.com.petz.cliente_pet.pet.application.service;

import java.util.List;
import java.util.UUID;

import br.com.petz.cliente_pet.pet.domain.Pet;

public interface PetRepository {

    Pet salvaPet(Pet pet);

    List<Pet> buscaPetsClienteId(UUID idCliente);

    Pet buscaPetId(UUID idPet);

    void deletaPet(Pet pet);

    

}
