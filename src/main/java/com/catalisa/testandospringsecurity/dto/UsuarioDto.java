package com.catalisa.testandospringsecurity.dto;

import com.catalisa.testandospringsecurity.model.UsuarioModel;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class UsuarioDto {
    @NotBlank(message = "campo vasio")
    private String nome;
    @NotNull(message = "Campo vasio")
    private int idade;
    @NotBlank(message = "campo vasio")
    private String telefone;
    @NotBlank(message = "campo vasio")
    private String loguin;
    @NotBlank(message = "campo vasio")
    private String senha;

    public UsuarioDto(String nome, int idade, String telefone, String loguin, String senha) {
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
        this.loguin = loguin;
        this.senha = senha;
    }

    public UsuarioModel converterParaUsuarioModel() {
        return new UsuarioModel(nome, idade, telefone, loguin, senha);
    }
}
