package br.inf.brunoruaro.model;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "usuario")
@Entity
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

    public Usuario() {
    }

    public Usuario(Integer usuarioId, String nome, String email, Long cpf, Operador operador) {
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.operador = operador;
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

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    @Override
    public String toString() {
        return "Usuario: " + usuarioId +
                ", nome: '" + nome +
                ", email: '" + email +
                ", CPF: '" + cpf;
    }
}
