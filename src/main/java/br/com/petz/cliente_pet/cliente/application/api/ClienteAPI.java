package br.com.petz.cliente_pet.cliente.application.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/v1/cliente")
public interface ClienteAPI {
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    ClienteResponse postCliente(@Valid @RequestBody ClienteRequest clienteRequest);

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    List<ClienteListResponse> getTodosClientes();
}
