package com.catalisa.testandospringsecurity.service;

import com.catalisa.testandospringsecurity.dto.UsuarioDto;
import com.catalisa.testandospringsecurity.dto.UsuarioRespostaDto;
import com.catalisa.testandospringsecurity.model.UsuarioModel;
import com.catalisa.testandospringsecurity.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;


    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    public UsuarioRespostaDto exibirUsuario(Long id) {
        Optional<UsuarioModel> optionalUsuarioModel = usuarioRepository.findById(id);
        if (optionalUsuarioModel.isEmpty()) {
            throw new RuntimeException("este usuário não foi cadastrado");
        }
        return UsuarioRespostaDto.converterParaRespostaDto(optionalUsuarioModel.get());
    }

    public UsuarioRespostaDto cadastrar(UsuarioDto usuarioDto) {
        Optional<UsuarioModel> optionalUsuarioModel = usuarioRepository.findByLogin(usuarioDto.getLogin());
        if (optionalUsuarioModel.isPresent()) {
            throw new RuntimeException("este usuário já existe");
        }
        UsuarioModel usuarioModel = usuarioDto.converterParaUsuarioModel();
usuarioModel.setSenha(passwordEncoder().encode(usuarioModel.getSenha()));

        UsuarioModel usuario = usuarioRepository.save(usuarioModel);
        return UsuarioRespostaDto.converterParaRespostaDto(usuario);
    }
}
