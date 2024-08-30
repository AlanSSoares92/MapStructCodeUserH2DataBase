package com.codecrud.mappercodecrud.controller;

import com.codecrud.mappercodecrud.business.UsuarioService;
import com.codecrud.mappercodecrud.business.dto.UserRequestDTO;
import com.codecrud.mappercodecrud.business.dto.UserResponseDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAll() {
        return ResponseEntity.ok(service.pegarTodosUsuarios());
    }

    @GetMapping("$/{email}")
    public ResponseEntity<UserResponseDTO> pegarPorEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok(service.pegarPorEmail(email));
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> salvarUsuario(@RequestBody UserRequestDTO requestDTO) {
        return ResponseEntity.ok(service.salvarUsuario(requestDTO));

    }

    @DeleteMapping("$/{email}")
    public ResponseEntity<UserResponseDTO> deletarPorEmail(@RequestParam("email") String email) {
        return ResponseEntity.ok().build();
    }


}
