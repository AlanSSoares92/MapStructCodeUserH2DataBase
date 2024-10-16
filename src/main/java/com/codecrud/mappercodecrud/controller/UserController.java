package com.codecrud.mappercodecrud.controller;

import com.codecrud.mappercodecrud.business.UsuarioService;
import com.codecrud.mappercodecrud.business.dto.UserRequestDTO;
import com.codecrud.mappercodecrud.business.dto.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAll() {
   if(!service.pegarTodosUsuarios().isEmpty())
        return ResponseEntity.ok(service.pegarTodosUsuarios());

   return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id) {
        if(service.findById(id) != null)
            return ResponseEntity.ok(service.findById(id));

        return ResponseEntity.badRequest().build();

    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> salvarUsuario(@RequestBody UserRequestDTO requestDTO, UriComponentsBuilder uri) {
      //  return ResponseEntity.created(uri.path("/usuario/{id}").buildAndExpand().toUri()).body(service.salvarUsuario(requestDTO));
    return ResponseEntity.ok(service.salvarUsuario(requestDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        if(service.findById(id) != null){
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();

    }


}
