package com.codecrud.mappercodecrud.business.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserRequestDTO (@JsonProperty(required = true) String nome, @JsonProperty(required = true)  String email, @JsonProperty(required = true) String senha){

}