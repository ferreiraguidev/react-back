package com.example.reactback.mapper;


import com.example.reactback.controller.DTOS.ModelRequestDTO;
import com.example.reactback.controller.DTOS.ModelResponseDTO;
import com.example.reactback.model.Model;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public class ModelMapper {


    public static Model toDomain(final ModelRequestDTO requestDTO){
        return new Model(null, requestDTO.name(), requestDTO.email(), requestDTO.login(),
                requestDTO.password(),requestDTO.passwordConfirmation());
    }

    public static ModelResponseDTO toDto(final Model model){
        return new ModelResponseDTO(model.getName(), model.getEmail(), model.getLogin(),
                model.getPassword(),model.getPasswordConfirmation());
    }
}
