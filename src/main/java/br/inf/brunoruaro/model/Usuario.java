package br.inf.brunoruaro.model;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "usuario")
@Entity
public class Usuario {

    @Column(name = "usuario_id")
    @Id
    private Integer usuarioId;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private Long cpf;

    @OneToMany(mappedBy = "usuario")
    private List<Movimentacao> movimentacoes;

    @OneToMany(mappedBy = "usuario")
    private List<HistoricoMovimentacoes> historicoMovimentacoes;

    @OneToMany(mappedBy = "usuario")
    private List<HistoricoCadastros> historicoCadastros;

    public Usuario() {
    }

    public Usuario(Integer usuarioId, String nome, String email, Long cpf) {
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Usuario: " + usuarioId +
                ", nome: '" + nome +
                ", email: '" + email +
                ", cpf: '" + cpf;
    }
}
