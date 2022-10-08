package com.catalisa.testandospringsecurity.controller;

import com.catalisa.testandospringsecurity.dto.UsuarioDto;
import com.catalisa.testandospringsecurity.dto.UsuarioRespostaDto;
import com.catalisa.testandospringsecurity.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ControllerAdvice
@RestController
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping(path = "/usuarios/exibir/{login}")
    public ResponseEntity<UsuarioRespostaDto> exibirUsuario(@PathVariable Long id) {
        UsuarioRespostaDto usuarioRespostaDto = usuarioService.exibirUsuario(id);
        return ResponseEntity.ok(usuarioRespostaDto);
    }


    @PostMapping(path = "/usuarios/cadastrar")
    public ResponseEntity<UsuarioRespostaDto> cadastrarUsuario(@RequestBody @Valid UsuarioDto usuarioDto) {
        UsuarioRespostaDto usuarioRespostaDto = usuarioService.cadastrar(usuarioDto);

        return new ResponseEntity<>(usuarioRespostaDto, HttpStatus.CREATED);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<String>> handleConstraint(ConstraintViolationException e) {
        Stream<String> listaDeErros = e.getConstraintViolations().stream().map(violation ->
            violation.getPropertyPath() + " : " + violation.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listaDeErros.collect(Collectors.toList()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handlerMethodArgument(MethodArgumentNotValidException methodArgumentNotValidException) {

        Stream<String> listaDeErros = methodArgumentNotValidException.getBindingResult().getAllErrors().stream().map(error -> ((FieldError) error).getField() + " : " + error.getDefaultMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listaDeErros.collect(Collectors.toList()));
    }


}
