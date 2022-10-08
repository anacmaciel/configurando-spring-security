package com.catalisa.testandospringsecurity.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Privilegio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @ManyToMany(mappedBy = "privilegios")
    private Collection<Role> roles;
}
