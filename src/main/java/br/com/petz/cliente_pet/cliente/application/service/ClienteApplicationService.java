package br.com.petz.cliente_pet.cliente.application.service;

//import java.util.List;

import org.springframework.stereotype.Service;

//import br.com.petz.cliente_pet.cliente.application.api.ClienteListResponse;
import br.com.petz.cliente_pet.cliente.application.api.ClienteRequest;
import br.com.petz.cliente_pet.cliente.application.api.ClienteResponse;
import br.com.petz.cliente_pet.cliente.application.repository.ClienteRepository;
import br.com.petz.cliente_pet.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public ClienteResponse criaCliente(ClienteRequest clienteRequest) {
        log.info("[Inicia] ClienteApplicationService - criaCliente");
        Cliente cliente = clienteRepository.salva(new Cliente(clienteRequest));
        log.info("[Finaliza] ClienteApplicationService - criaCliente");
        return ClienteResponse.builder()
                .idCliente(cliente.getIdCliente())
                .build();
    }

    // @Override
    // public List<ClienteListResponse> obtemTodosClientes() {
    //     log.info("[Inicia] ClienteApplicationService - obtemTodosClientessions");
    //     List<Cliente> clientes = clienteRepository.findAll();
    //     log.info("[Finaliza] ClienteApplicationService - obtemTodosClientessions");
    //     return null;
    // }

}
