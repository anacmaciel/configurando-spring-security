package com.catalisa.testandospringsecurity.security;

import com.catalisa.testandospringsecurity.exception.ResourceNotFoundException;
import com.catalisa.testandospringsecurity.model.UsuarioModel;
import com.catalisa.testandospringsecurity.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UsuarioDetalhesService implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrLogin) throws UsernameNotFoundException {
        UsuarioModel usuarioModel = usuarioRepository.findByUsernameOrLogin(usernameOrLogin, usernameOrLogin)
                .orElseThrow(() ->
        new UsernameNotFoundException("Não existe um usuário com o  username ou login:" + usernameOrLogin)

                );
        return UsuarioPrincipal.criar(usuarioModel);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        UsuarioModel usuarioModel = usuarioRepository.findById(id).orElseThrow(
                ()  -> new ResourceNotFoundException("User", "id", id)
        );

    return UsuarioPrincipal.criar(usuarioModel);
    }
}
