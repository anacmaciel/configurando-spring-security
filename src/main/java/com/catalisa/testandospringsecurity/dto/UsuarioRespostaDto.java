package com.catalisa.testandospringsecurity.dto;

import com.catalisa.testandospringsecurity.model.UsuarioModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UsuarioRespostaDto {
private String nome;
private String login;
private String senha;

public UsuarioRespostaDto(UsuarioModel usuarioModel) {
    this.nome = usuarioModel.getNome();
    this.login = usuarioModel.getLogin();
    this.senha = usuarioModel.getSenha();
}

public static UsuarioRespostaDto converterParaRespostaDto(UsuarioModel usuarioModel) {
    return new UsuarioRespostaDto(usuarioModel.getNome(), usuarioModel.getLogin(), usuarioModel.getSenha());
}
}
