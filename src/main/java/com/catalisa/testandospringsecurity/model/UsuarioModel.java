package com.catalisa.testandospringsecurity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioModel {
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, length = 3)
    private int idade;
    @Column(nullable = false, unique = true, length = 11)
    private String telefone;
    @Id
    @Column(nullable = false, length = 15, unique = true)
    private String loguin;
    @Column(unique = true, length = 6, nullable = false)
    private String senha;
}
