package com.catalisa.testandospringsecurity.repository;

import com.catalisa.testandospringsecurity.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
Optional<UsuarioModel> findByLogin(String login);
Optional<UsuarioModel> findByUsernameOrLogin(String username, String login);

Optional<UsuarioModel> findByUsername(String userName);
}
