package br.inf.brunoruaro.model;
import jakarta.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "historico_movimentacoes")
public class HistoricoMovimentacoes {

    @Column(name = "historico_mov_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence_id_historico_movimentacoes", sequenceName = "sequence_historico_movimentacoes")
    private Integer historicoMovId;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "movimentacao_id", referencedColumnName = "movimentacao_id")
    private Movimentacao movimentacao;

    @Column(name = "data_movimentacao")
    private Date data;

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

    @Column(name = "quantidade_movimentada")
    private Integer quantidade;

    public HistoricoMovimentacoes() {
    }

    public HistoricoMovimentacoes(Integer historicoMovId, Movimentacao movimentacao, Date data, TipoMovimentacao tipoMovimentacao, Operador operador, Usuario usuario, Item item, Integer quantidade) {
        this.historicoMovId = historicoMovId;
        this.movimentacao = movimentacao;
        this.data = data;
        this.tipoMovimentacao = tipoMovimentacao;
        this.operador = operador;
        this.usuario = usuario;
        this.item = item;
        this.quantidade = quantidade;
    }

    public Integer getHistoricoMovId() {
        return historicoMovId;
    }

    public void setHistoricoMovId(Integer historicoMovId) {
        this.historicoMovId = historicoMovId;
    }

    public Movimentacao getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(Movimentacao movimentacao) {
        this.movimentacao = movimentacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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
        return "HistoricoMovimentacoes{" +
                "historicoMovId=" + historicoMovId +
                ", movimentacao=" + movimentacao +
                ", data=" + data +
                ", tipoMovimentacao=" + tipoMovimentacao +
                ", operador=" + operador +
                ", usuario=" + usuario +
                ", item=" + item +
                ", quantidade=" + quantidade +
                '}';
    }
}
