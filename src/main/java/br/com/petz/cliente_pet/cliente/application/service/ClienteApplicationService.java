package br.com.petz.cliente_pet.cliente.application.service;

import org.springframework.stereotype.Service;
import br.com.petz.cliente_pet.cliente.application.api.ClienteRequest;
import br.com.petz.cliente_pet.cliente.application.api.ClienteResponse;
import br.com.petz.cliente_pet.cliente.domain.Cliente;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ClienteApplicationService implements ClienteService{

    @Override
    public ClienteResponse criaCliente(ClienteRequest clienteRequest) {
        log.info("[Inicia] ClienteApplicationService - criaCliente");
        Cliente cliente = clienteRepository.salva(new Cliente(clienteRequest));
        log.info("[Finaliza] ClienteApplicationService - criaCliente");
        return null;
    }

}
