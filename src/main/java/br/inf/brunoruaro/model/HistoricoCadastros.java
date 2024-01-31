package br.inf.brunoruaro.model;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "historico_cadastros")
public class HistoricoCadastros {

    @Column(name = "historico_cad_id")
    @Id
    private Integer historicoCadId;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    private Item item;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "operador_id", referencedColumnName = "operador_id")
    private Operador operador;

    @Column(name = "data_cadastro")
    private Date data;

    public HistoricoCadastros() {
    }

    public HistoricoCadastros(Integer historicoCadId, Usuario usuario, Item item, Operador operador, Date data) {
        this.historicoCadId = historicoCadId;
        this.usuario = usuario;
        this.item = item;
        this.operador = operador;
        this.data = data;
    }

    public Integer getHistoricoCadId() {
        return historicoCadId;
    }

    public void setHistoricoCadId(Integer historicoCadId) {
        this.historicoCadId = historicoCadId;
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

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HistoricoCadastros{" +
                "historicoCadId=" + historicoCadId +
                ", usuario=" + usuario +
                ", item=" + item +
                ", operador=" + operador +
                ", data=" + data +
                '}';
    }
}
