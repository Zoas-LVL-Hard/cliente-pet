package br.com.petz.cliente_pet.cliente.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.petz.cliente_pet.cliente.domain.Cliente;
import lombok.Value;

@Value
public class ClienteListResponse {
    private UUID idCliente;
    private String nomeCompleto;
    private String cpf;
    private String email;
    private String celular;

    //!Aqui é feita uma conversão de listas com o uso de stream com o map :: new e Collectors.toList(),
    //!junto com a referencia da classe com o this.
    public static List<ClienteListResponse> converte(List<Cliente> clientes) {
        return clientes.stream()
        .map(ClienteListResponse::new)
        .collect(Collectors.toList());
    }

    public ClienteListResponse(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.nomeCompleto = cliente.getNomeCompleto();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.celular = cliente.getCelular();
    }

}
