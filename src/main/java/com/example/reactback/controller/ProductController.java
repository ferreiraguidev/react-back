package com.example.reactback.controller;


import com.example.reactback.controller.DTOS.ProductResponseDTO;
import com.example.reactback.gateway.ProductGateway;
import com.example.reactback.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductMapper mapper;
    private final ProductGateway gateway;

    @PostMapping("/upload")
    public ProductResponseDTO save(@RequestParam("image") final MultipartFile image)
            throws IOException {
        return mapper.fromDomain(gateway.save(image));
    }
}
