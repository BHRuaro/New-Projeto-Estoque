package br.inf.brunoruaro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "usuario")
@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Column(name = "usuario_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence_id_usuario", sequenceName = "sequence_usuario")
    private Integer usuarioId;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private Long cpf;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "operador_id", referencedColumnName = "operador_id")
    private Operador operador;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Movimentacao> movimentacoes;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<HistoricoMovimentacoes> historicoMovimentacoes;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<HistoricoCadastros> historicoCadastros;
}
