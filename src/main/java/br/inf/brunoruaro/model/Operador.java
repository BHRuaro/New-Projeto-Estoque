package br.inf.brunoruaro.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;


@Entity
@Table(name = "operador")
public class Operador {
    @Column(name = "operador_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "operador")
    private List<Movimentacao> movimentacoes;

    @OneToMany(mappedBy = "operador")
    private List<HistoricoCadastros> historicoCadastros;

    @OneToMany(mappedBy = "operador")
    private List<HistoricoMovimentacoes> historicoMovimentacoes;

    public Operador() {
    }

    public Operador(Integer operadorId, String nome, String senha, String cargo, Float salario,
                    Date dataContratacao) {
        this.operadorId = operadorId;
        this.nome = nome;
        this.senha = senha;
        this.cargo = cargo;
        this.salario = salario;
        this.dataContratacao = dataContratacao;
    }

    public Integer getOperadorId() {
        return operadorId;
    }

    public void setOperadorId(Integer operadorId) {
        this.operadorId = operadorId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Float getSalario() {
        if (this.salario != null) {
            return this.salario;
        } else {
            return null;
        }
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public Date getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        if (dataContratacao != null){
            this.dataContratacao = dataContratacao;
        }else {
            this.dataContratacao = new Date(System.currentTimeMillis());
        }
    }

    @Override
    public String toString() {
        return "Operador" + operadorId + " - " + nome;
    }
}
