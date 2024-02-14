package br.inf.brunoruaro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import java.sql.Date;
import jakarta.persistence.OneToMany;
import java.util.List;


@Entity
@Table(name = "operador")
public class Operador {
    @Column(name = "operador_id")
    @Id
    private Integer operadorId;
    @Column
    private String nome;
    @Column
    private String senha;
    @Column
    private String cargo;
    @Column
    private Float salario;
    @Column
    private java.sql.Date data_contratacao;

    @OneToMany(mappedBy = "operador")
    private List<Movimentacao> movimentacoes;

    @OneToMany(mappedBy = "operador")
    private List<HistoricoCadastros> historicoCadastros;

    @OneToMany(mappedBy = "operador")
    private List<HistoricoMovimentacoes> historicoMovimentacoes;

    public Operador() {
    }

    public Operador(Integer operador_id, String nome, String senha, String cargo, Float salario,
                    java.sql.Date data_contratacao) {
        this.operadorId = operador_id;
        this.nome = nome;
        this.senha = senha;
        this.cargo = cargo;
        this.salario = salario;
        this.data_contratacao = data_contratacao;
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

    public Date getData_contratacao() {
        return data_contratacao;
    }

    public void setData_contratacao(Date data_contratacao) {
        if (data_contratacao != null){
            this.data_contratacao = data_contratacao;
        }else {
            this.data_contratacao = new Date(System.currentTimeMillis());
        }
    }

    @Override
    public String toString() {
        return "Operador" + operadorId + " - " + nome;
    }
}
