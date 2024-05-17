package br.inf.brunoruaro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;


@Entity
@Table(name = "operador")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Operador {
    @Column(name = "operador_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence_id_operador", sequenceName = "sequence_operador")
    private Integer operadorId;
    @Column
    private String nome;
    @Column
    private String senha;
    @Column
    private String cargo;
    @Column
    private Float salario;
    @Column(name = "data_contratacao")
    private Date dataContratacao;

    @OneToMany(mappedBy = "operador", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Movimentacao> movimentacoes;

    @OneToMany(mappedBy = "operador", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<HistoricoCadastros> historicoCadastros;

    @OneToMany(mappedBy = "operador", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<HistoricoMovimentacoes> historicoMovimentacoes;
}
