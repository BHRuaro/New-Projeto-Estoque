package br.inf.brunoruaro.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "movimentacoes")
@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movimentacao {

    @Column(name = "movimentacao_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence_id_movimentacao", sequenceName = "sequence_movimentacao")
    private Integer movimentacaoId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "tipo_movimentacao_id", referencedColumnName = "tipo_movimentacao_id")
    private TipoMovimentacao tipoMovimentacao;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "operador_id", referencedColumnName = "operador_id")
    private Operador operador;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    private Item item;

    @Column
    private Integer quantidade;

    @Override
    public String toString() {

        if (usuario == null) {
            return "Tipo da movimentação:\n " + tipoMovimentacao.getTipoMovimentacaoId() + " - "
                    + tipoMovimentacao.getDescricao()
                    + "\nOperador: " + operador.getOperadorId() + " - " + operador.getNome() + "\nItem: "
                    + item.getItemId() + " - "
                    + item.getNome() + "\nQuantidade: " + getQuantidade() + "\n";
        } else {
            return "Tipo da movimentação:\n " + tipoMovimentacao.getTipoMovimentacaoId() + " - "
                    + tipoMovimentacao.getDescricao()
                    + "\nOperador: " + operador.getOperadorId() + " - " + operador.getNome() + "\nUsuario: "
                    + usuario.getUsuarioId() + " - " + usuario.getNome() + "\nItem: " + item.getItemId() + " - "
                    + item.getNome() + "\nQuantidade: " + getQuantidade() + "\n";
        }
    }
}
