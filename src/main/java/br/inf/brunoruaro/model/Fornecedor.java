package br.inf.brunoruaro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "fornecedor")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Fornecedor {


    @Column(name = "fornecedor_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence_id_fornecedor", sequenceName = "sequence_fornecedor")
    private Integer fornecedorId;

    @Column
    private String nome;

    @Column
    private Long cnpj;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "operador_id", referencedColumnName = "operador_id")
    private Operador operador;

    @OneToOne(mappedBy = "fornecedor", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private HistoricoCadastros historicoCadastros;

    @OneToMany(mappedBy = "fornecedor", fetch = FetchType.EAGER)
    private List<Item> itens;
}