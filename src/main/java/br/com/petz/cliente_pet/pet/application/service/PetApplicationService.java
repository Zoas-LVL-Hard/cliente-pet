package br.com.petz.cliente_pet.pet.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.petz.cliente_pet.cliente.application.service.ClienteService;
import br.com.petz.cliente_pet.pet.application.api.PetClienteDetalheResponse;
import br.com.petz.cliente_pet.pet.application.api.PetClienteListResponse;
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

    //!O metodo converte serve para filtrar/transformar os dados response em uma lista para o front-end. Como o front não usa todas as informações, apenas o necessário é mostrado.
    @Override
    public List<PetClienteListResponse> buscaPetsClienteId(UUID idCliente) {
        log.info("[Inicia] PetApplicationService - buscaPetsClienteId");
        clienteService.buscaClienteAtravesId(idCliente);
        List<Pet> petsDoCliente = petRepository.buscaPetsClienteId(idCliente);
        log.info("[Finaliza] PetApplicationService - buscaPetsClienteId");
        return PetClienteListResponse.converte(petsDoCliente);
    }

    @Override
    public PetClienteDetalheResponse buscaPetClienteId(UUID idCliente, UUID idPet) {
        log.info("[Inicia] PetApplicationService - buscaPetClienteId");
        clienteService.buscaClienteAtravesId(idCliente);
        Pet pet = petRepository.buscaPetId(idPet);
        log.info("[Finaliza] PetApplicationService - buscaPetClienteId");
        return new PetClienteDetalheResponse(pet);
    }

}
