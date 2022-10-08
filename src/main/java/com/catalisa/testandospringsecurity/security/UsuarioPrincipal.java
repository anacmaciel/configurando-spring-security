package com.catalisa.testandospringsecurity.security;

import com.catalisa.testandospringsecurity.model.UsuarioModel;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
public class UsuarioPrincipal implements UserDetails {
    private Long id;
    private String nome;
    private String userName;
    private int idade;
    private String telefone;
    private String login;
    private String senha;
    private Collection<? extends GrantedAuthority> authorities;

    public static UsuarioPrincipal criar(UsuarioModel usuarioModel) {
        List<GrantedAuthority> grantedAuthorities = usuarioModel.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getNome())).collect(Collectors.toList());
        return new UsuarioPrincipal(usuarioModel.getId(), usuarioModel.getNome(), usuarioModel.getUserName(), usuarioModel.getIdade(), usuarioModel.getTelefone(), usuarioModel.getLogin(), usuarioModel.getSenha(), grantedAuthorities);
    }


    public String getLogin() {
        return login;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getTelefone() {
        return telefone;
    }


    public String getSenha() {
        return senha;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        UsuarioPrincipal that = (UsuarioPrincipal) obj;
        return Objects.equals(id, that.id);
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


}



