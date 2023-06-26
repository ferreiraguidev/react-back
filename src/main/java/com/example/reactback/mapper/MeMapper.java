package com.example.reactback.mapper;

import com.example.reactback.controller.DTOS.ModelResponseDTO;
import com.example.reactback.model.Model;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MeMapper {

    ModelResponseDTO fromDomain(Model model);
}
