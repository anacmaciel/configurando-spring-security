package com.catalisa.testandospringsecurity.repository;

import com.catalisa.testandospringsecurity.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, String> {
}
