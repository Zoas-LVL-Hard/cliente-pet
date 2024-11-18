package br.com.petz.cliente_pet.pet.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.petz.cliente_pet.cliente.application.service.ClienteService;
import br.com.petz.cliente_pet.pet.application.api.PetRequest;
import br.com.petz.cliente_pet.pet.application.api.PetResponse;
import br.com.petz.cliente_pet.pet.domain.Pet;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class PetApplicationService implements PetService {

    private final PetRepository petRepository;
    private final ClienteService clienteService;

    @Override
    public PetResponse criaPet(UUID idCliente, @Valid PetRequest petRequest) {
        log.info("[Inicia] PetApplicationService - criaPet");
        clienteService.buscaClienteAtravesId(idCliente);
        Pet pet = petRepository.salvaPet(new Pet(idCliente, petRequest));
        log.info("[Finaliza] PetApplicationService - criaPet");
        return new PetResponse(pet.getIdPet());
    }

}
