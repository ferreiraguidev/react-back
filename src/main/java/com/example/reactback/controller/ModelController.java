package com.example.reactback.controller;


import com.example.reactback.controller.DTOS.ModelRequestDTO;
import com.example.reactback.controller.DTOS.ModelResponseDTO;
import com.example.reactback.gateway.ModelGateway;
import com.example.reactback.model.Model;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.reactback.mapper.ModelMapper.toDomain;
import static com.example.reactback.mapper.ModelMapper.toDto;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;


@RequiredArgsConstructor
@RestController()
public class ModelController {

    private ModelGateway modelGateway;


    @ResponseStatus(CREATED)
    @PostMapping("save")
    public ModelResponseDTO save(@RequestBody final ModelRequestDTO requestDTO) {
        val model = toDomain(requestDTO);
        val savedModel = modelGateway.save(model);
        return toDto(savedModel);
    }

    @ResponseStatus(OK)
    @GetMapping("findAll")
    public List<Model> listAll(){
        return modelGateway.listAll();
    }
}
