package com.catalisa.testandospringsecurity.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
@Getter
@Setter
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @ManyToMany(mappedBy = "roles")
    private Collection<UsuarioModel> usuarios;
@ManyToMany
    @JoinTable(
            name = "roles_privilegios",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                  name =  "privilegio_id", referencedColumnName = "id"
            )
    )
    private Collection<Privilegio> privilegios;
}
