package com.codecrud.mappercodecrud.business.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserResponseDTO(@JsonProperty(required = true) String nome, @JsonProperty(required = true)  String email) {

}
