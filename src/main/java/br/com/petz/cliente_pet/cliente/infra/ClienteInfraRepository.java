package br.com.petz.cliente_pet.cliente.infra;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.petz.cliente_pet.cliente.application.repository.ClienteRepository;
import br.com.petz.cliente_pet.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ClienteInfraRepository implements ClienteRepository {
    private final ClienteSpringDataJPARepository clienteSpringDataJPARepository;

    @Override
    public Cliente salva(Cliente cliente) {
        log.info("[Inicia] ClienteInfraRepository - salva");
        clienteSpringDataJPARepository.save(cliente);
        log.info("[Finaliza] ClienteInfraRepository - salva");
        return cliente;
    }

    @Override
    public List<Cliente> buscaTodosClientes() {
        log.info("[Inicia] ClienteInfraRepository - buscaTodosClientes");
        List<Cliente> todosClientes = clienteSpringDataJPARepository.findAll();
        log.info("[Finaliza] ClienteInfraRepository - buscaTodosClientes");
        return todosClientes;
    }
}
