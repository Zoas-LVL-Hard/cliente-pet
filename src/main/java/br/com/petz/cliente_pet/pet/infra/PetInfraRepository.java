package br.com.petz.cliente_pet.pet.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.petz.cliente_pet.pet.application.service.PetRepository;
import br.com.petz.cliente_pet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PetInfraRepository implements PetRepository {

    private final PetSpringDataJPARepository petSpringDataJPARepository;
    @Override
    public Pet salvaPet(Pet pet) {
        log.info("[Inicia] PetInfraRepository - salvaPet");
        petSpringDataJPARepository.save(pet);
        log.info("[Finaliza] PetInfraRepository - salvaPet");
        return pet;
    }
    @Override
    public List<Pet> buscaPetsClienteId(UUID idCliente) {
        log.info("[Inicia] PetInfraRepository - buscaPetsClienteId");
        //List<Pet> pets = petSpringDataJPARepository.(idCliente);
        log.info("[Finaliza] PetInfraRepository - buscaPetsClienteId");
        return null;
    }

}
