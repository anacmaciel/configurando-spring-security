package com.catalisa.testandospringsecurity.model;

import com.catalisa.testandospringsecurity.enumeration.PerfilEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioModel extends Serializable {

    private static final long serialVersionUID = 306411570471828345L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nome;
    private String username;
    @Column(nullable = false, length = 3)
    private int idade;
    @Column(nullable = false, unique = true, length = 11)
    private String telefone;
    @Column(nullable = false, length = 15, unique = true)
    private String login;
    @Column(nullable = false)
    private String senha;
@Enumerated(EnumType.STRING)
    private PerfilEnum perfil;
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
