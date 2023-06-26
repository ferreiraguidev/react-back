package com.example.reactback.controller;


import com.example.reactback.controller.DTOS.ModelResponseDTO;
import com.example.reactback.gateway.ModelGateway;
import com.example.reactback.mapper.MeMapper;
import com.example.reactback.model.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("user/me")
@RestController
public class MeController {

    private final ModelGateway modelGateway;
    private final MeMapper meMapper;

    @ResponseStatus(OK)
    @GetMapping
    public ModelResponseDTO findById(Model model) {
        return meMapper.fromDomain(modelGateway.findByLogin(model.getLogin()));
    }

}
