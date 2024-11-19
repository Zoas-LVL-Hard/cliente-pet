package br.com.petz.cliente_pet.pet.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.petz.cliente_pet.pet.domain.Pet;
import java.util.List;


public interface PetSpringDataJPARepository extends JpaRepository<Pet, UUID>{
    List<Pet> findByIdClienteTutor(UUID idClienteTutor);
}
