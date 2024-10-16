package com.codecrud.mappercodecrud.business;

import com.codecrud.mappercodecrud.business.dto.UserRequestDTO;
import com.codecrud.mappercodecrud.business.dto.UserResponseDTO;
import com.codecrud.mappercodecrud.business.mapstruct.UsuarioMapper;
import com.codecrud.mappercodecrud.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    @Autowired
    private UsuarioMapper mapper;
    @Autowired
    private UsuarioRepository repository;


    public UserResponseDTO salvarUsuario(UserRequestDTO request) {
        // retorno = respostaDto(convertendo de entidade para dto>
        // dentro do repository.save (passando conversão de requestDTO para entidade) e a conversão
        //para o retorno como DTO ja foi iniciada no return.
        return mapper.toUserResponseDTO(
                repository.save(
                        mapper.toUserEntity(request)));
    }

    public List<UserResponseDTO> pegarTodosUsuarios() {

        return mapper.todosParaListaResponseDTO(repository.findAll());
    }

    public UserResponseDTO findById(Long id) {

        return mapper.toUserResponseDTO(repository.getById(id));
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
