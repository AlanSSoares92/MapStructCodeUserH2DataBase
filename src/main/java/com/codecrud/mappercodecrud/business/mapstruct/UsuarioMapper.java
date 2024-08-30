package com.codecrud.mappercodecrud.business.mapstruct;

import com.codecrud.mappercodecrud.business.dto.UserRequestDTO;
import com.codecrud.mappercodecrud.business.dto.UserResponseDTO;
import com.codecrud.mappercodecrud.infrastructure.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    @Mapping(target = "id", ignore = true)
    UserEntity toUserEntity(UserRequestDTO request);
    UserResponseDTO toUserResponseDTO(UserEntity entity);
    List<UserResponseDTO> todosParaListaResponseDTO(List<UserEntity> lista);

}
