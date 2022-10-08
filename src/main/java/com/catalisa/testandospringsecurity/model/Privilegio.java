package com.catalisa.testandospringsecurity.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Privilegio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @ManyToMany(mappedBy = "privilegios")
    private Collection<Role> roles;
}
