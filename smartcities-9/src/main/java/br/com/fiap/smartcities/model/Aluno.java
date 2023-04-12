package br.com.fiap.smartcities.model;

import javax.persistence.*;

@Entity
@Table(name="TBL_ALUNO")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ra;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private int senha;

    public Long getRa() {
        return ra;
    }

    public void setRa(Long ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }
}
