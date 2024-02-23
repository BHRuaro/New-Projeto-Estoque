package br.inf.brunoruaro.model;

import jakarta.persistence.*;

@Table(name = "movimentacoes")
@Entity
public class Movimentacao {

    @Column(name = "movimentacao_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence_id_movimentacao", sequenceName = "sequence_movimentacao")
    private Integer movimentacaoId;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "tipo_movimentacao_id", referencedColumnName = "tipo_movimentacao_id")
    private TipoMovimentacao tipoMovimentacao;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "operador_id", referencedColumnName = "operador_id")
    private Operador operador;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    private Item item;

    @Column
    private Integer quantidade;

    public Movimentacao() {
    }

    public Movimentacao(Integer movimentacaoId, TipoMovimentacao tipoMovimentacao, Operador operador, Usuario usuario, Item item, Integer quantidade) {
        this.movimentacaoId = movimentacaoId;
        this.tipoMovimentacao = tipoMovimentacao;
        this.operador = operador;
        this.usuario = usuario;
        this.item = item;
        this.quantidade = quantidade;
    }

    public Integer getMovimentacaoId() {
        return movimentacaoId;
    }

    public void setMovimentacaoId(Integer movimentacaoId) {
        this.movimentacaoId = movimentacaoId;
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

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
