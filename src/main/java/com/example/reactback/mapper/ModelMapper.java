package com.example.reactback.mapper;


import com.example.reactback.controller.DTOS.ModelRequestDTO;
import com.example.reactback.controller.DTOS.ModelResponseDTO;
import com.example.reactback.model.Model;
import org.springframework.stereotype.Component;

@Component
public class ModelMapper {


    public static Model toDomain(final ModelRequestDTO requestDTO){
        return new Model(null, requestDTO.name(), requestDTO.email(),
                requestDTO.description(),requestDTO.description());
    }

    public static ModelResponseDTO toDto(final Model model){
        return new ModelResponseDTO(model.getName(),
                model.getEmail(),model.getPassword(),model.getDescription());
    }
}
