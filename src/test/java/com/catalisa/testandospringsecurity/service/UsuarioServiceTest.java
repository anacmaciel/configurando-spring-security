package com.catalisa.testandospringsecurity.service;

import com.catalisa.testandospringsecurity.dto.UsuarioDto;
import com.catalisa.testandospringsecurity.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {
    @Mock
    private UsuarioRepository usuarioRepository;
    @InjectMocks
    UsuarioService usuarioService;

    private UsuarioDto usuarioDto;

    @BeforeEach

    private void iniciar() {
        usuarioDto = new UsuarioDto("teste", 26, "teste", "teste", "teste");
    }


    @Test
    void deveriaBuscarOUsuarioNoBanco() {
        when(usuarioRepository.findByLogin(usuarioDto.getLogin())).thenReturn(Optional.empty());


        assertThrows(RuntimeException.class, () -> {
            usuarioService.cadastrar(usuarioDto);
        });


        verify(usuarioRepository, times(1)).findByLogin ("teste");

    }

}