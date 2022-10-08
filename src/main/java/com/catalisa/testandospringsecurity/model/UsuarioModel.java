package com.catalisa.testandospringsecurity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, length = 3)
    private int idade;
    @Column(nullable = false, unique = true, length = 11)
    private String telefone;
    @Column(nullable = false, length = 15, unique = true)
    private String login;
    @Column(nullable = false)
    private String senha;
    @ManyToMany
    @JoinTable(
            name = "usuarios_roles",
            joinColumns = @JoinColumn(
                    name = "usuarios_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"
            )
    )
    private Collection<Role> roles;

    public UsuarioModel(String nome, int idade, String telefone, String login, String senha) {
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
        this.login = login;
        this.senha = senha;
    }
}
