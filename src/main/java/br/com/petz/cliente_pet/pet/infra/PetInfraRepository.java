package br.com.petz.cliente_pet.pet.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.petz.cliente_pet.handler.APIException;
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
    //!O Uso do var ajuda a deixar menos verboso. Pode ser usado o List<Pet> mas nesse caso o var se sai melhor.
    @Override
    public List<Pet> buscaPetsClienteId(UUID idCliente) {
        log.info("[Inicia] PetInfraRepository - buscaPetsClienteId");
        var pets = petSpringDataJPARepository.findByIdClienteTutor(idCliente);
        log.info("[Finaliza] PetInfraRepository - buscaPetsClienteId");
        return pets;
    }
    //!Aqui é retornado um Optional por causa do findById...
    @Override
    public Pet buscaPetId(UUID idPet) {
        log.info("[Inicia] PetInfraRepository - buscaPetId");
        var pet = petSpringDataJPARepository.findById(idPet).orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Pet não encontrado para esse ID " + idPet));
        log.info("[Finaliza] PetInfraRepository - buscaPetId");
        return pet;
    }
    @Override
    public void deletaPet(Pet pet) {
        log.info("[Inicia] PetInfraRepository - deletaPet");
        petSpringDataJPARepository.delete(pet);
        log.info("[Finaliza] PetInfraRepository - deletaPet");
    }

}
