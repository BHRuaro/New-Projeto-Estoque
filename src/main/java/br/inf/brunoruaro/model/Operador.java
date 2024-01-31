package br.inf.brunoruaro.model;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import java.sql.Date;


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

//    @OneToMany(mappedBy = "operador")
//    private List<Movimentacao> movimentacoes;

    public Operador() {
    }

    public Operador(int operador_id, String nome, String senha, String cargo, float salario,
                    java.sql.Date data_contratacao) {
        this.operadorId = operador_id;
        this.nome = nome;
        this.senha = senha;
        this.cargo = cargo;
        this.salario = salario;
        this.data_contratacao = data_contratacao;
    }

    public int getOperadorId() {
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

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Date getData_contratacao() {
        return data_contratacao;
    }

    public void setData_contratacao(Date data_contratacao) {
        this.data_contratacao = data_contratacao;
    }

    @Override
    public String toString() {
        return "Operador" + operadorId + " - " + nome;
    }
}
