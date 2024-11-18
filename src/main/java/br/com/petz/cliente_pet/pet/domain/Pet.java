package br.com.petz.cliente_pet.pet.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import br.com.petz.cliente_pet.pet.application.api.PetRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "idPet", updatable = false, unique = true, nullable = false)
    private UUID idPet;
    @NotNull
    @Column(columnDefinition = "uuid", name = "idClienteTutor", nullable = false)
    private UUID idClienteTutor;
    @NotBlank
    private String nomePet;
    @Enumerated (EnumType.STRING)
    private Porte porte;
    @NotNull
    private TipoPet tipo;
    public String microChip;
    @NotBlank
    public String raca;
    @Enumerated (EnumType.STRING)
    @NotNull
    public SexoPet sexo;
    public String pelagemCor;
    @NotNull
    private LocalDate dataDeNasc;
    public String rga;
    public Integer peso;
    
    private LocalDateTime momentoDoCadastro;
    private LocalDateTime dataHoraDaUltimaAlteracao;
    
    public Pet(UUID idCliente, PetRequest petRequest) {
        
        this.nomePet = petRequest.getNomePet();
        this.idClienteTutor = idCliente;
        this.porte = petRequest.getPorte();
        this.tipo = petRequest.getTipo();
        this.microChip = petRequest.getMicroChip();
        this.raca = petRequest.getRaca();
        this.sexo = petRequest.getSexo();
        this.pelagemCor = petRequest.getPelagemCor();
        this.dataDeNasc = petRequest.getDataDeNasc();
        this.rga = petRequest.getRga();
        this.peso = petRequest.getPeso();
        this.momentoDoCadastro = LocalDateTime.now();
        this.dataHoraDaUltimaAlteracao = LocalDateTime.now();
    }
}