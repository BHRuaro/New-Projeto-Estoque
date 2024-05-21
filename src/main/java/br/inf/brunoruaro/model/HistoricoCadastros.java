package br.inf.brunoruaro.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "historico_cadastros")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoCadastros {

    @Column(name = "historico_cad_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence_id_historico_cadastros", sequenceName = "sequence_historico_cadastros")
    private Integer historicoCadId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    private Item item;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "operador_id", referencedColumnName = "operador_id")
    private Operador operador;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "fornecedor_id", referencedColumnName = "fornecedor_id")
    private Fornecedor fornecedor;

    @Column(name = "data_cadastro")
    private Date data;
}
