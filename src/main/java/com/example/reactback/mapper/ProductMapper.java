package com.example.reactback.mapper;


import com.example.reactback.controller.DTOS.ProductResponseDTO;
import com.example.reactback.gateway.ProductGateway;
import com.example.reactback.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProductGateway.class})
public interface ProductMapper {

    ProductResponseDTO fromDomain(Product entity);
}
