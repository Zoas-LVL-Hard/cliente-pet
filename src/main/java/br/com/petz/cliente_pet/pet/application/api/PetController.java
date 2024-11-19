package br.com.petz.cliente_pet.pet.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.petz.cliente_pet.pet.application.service.PetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PetController implements PetAPI {

    private final PetService petService;

    @Override
    public PetResponse postPet(UUID idCliente, @Valid PetRequest petRequest) {
        log.info("[Inicia] PetController - postPet");
        log.info("[idCliente] {}", idCliente);
        PetResponse pet = petService.criaPet(idCliente, petRequest);
        log.info("[Finaliza] PetController - postPet");
        return pet;
    }

    @Override
    public List<PetClienteListResponse> getPetsClienteId(UUID idCliente) {
        log.info("[Inicia] PetController - getPetsClienteId");
        log.info("[idCliente] {}", idCliente);
        List<PetClienteListResponse> petsDoCliente = petService.buscaPetsClienteId(idCliente);
        log.info("[Finaliza] PetController - getPetsClienteId");
        return petsDoCliente;
    }

}
