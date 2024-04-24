package br.inf.brunoruaro.model;

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
    private List<Movimentacao> movimentacoes;

    @OneToMany(mappedBy = "usuario")
    private List<HistoricoMovimentacoes> historicoMovimentacoes;

    @OneToMany(mappedBy = "usuario")
    private List<HistoricoCadastros> historicoCadastros;

    @Override
    public String toString() {
        return "Usuario: " + usuarioId +
                ", nome: '" + nome +
                ", email: '" + email +
                ", CPF: '" + cpf;
    }
}
