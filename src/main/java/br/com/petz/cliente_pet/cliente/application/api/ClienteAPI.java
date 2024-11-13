package br.com.petz.cliente_pet.cliente.application.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/v1/cliente")
public interface ClienteAPI {
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    ClienteResponse postCliente(@Valid @RequestBody ClienteRequest clienteRequest);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<ClienteListResponse> getTodosClientes();

    @GetMapping(value = "/{idCliente}")
    @ResponseStatus(HttpStatus.OK)
    ClienteDetalhadoResponse getClienteAtravesId(@PathVariable UUID idCliente);

    @DeleteMapping(value = "/{idCliente}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletaClienteAtravesId(@PathVariable UUID idCliente);

    @PatchMapping(value = "/{idCliente}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void patchAlteraCliente(@PathVariable UUID idCliente, @Valid @RequestBody ClienteAlteracaoRequest clienteAlteracaoRequest);
}
