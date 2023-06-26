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
import static org.springframework.http.HttpStatus.*;


@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping
public class ModelController {

    private final ModelGateway modelGateway;


    @ResponseStatus(CREATED)
    @PostMapping("save")
    public ModelResponseDTO save(@RequestBody final ModelRequestDTO requestDTO) {
        val model = toDomain(requestDTO);
        val savedModel = modelGateway.save(model);
        return toDto(savedModel);
    }

    @ResponseStatus(OK)
    @GetMapping("users")
    public @ResponseBody List<Model> listAll() {
        return modelGateway.listAll();
    }

    @ResponseStatus(OK)
    @GetMapping("user/{id}")
    public Model findById(final @PathVariable Long id) {
        return modelGateway.findById(id);
    }

    @ResponseStatus(ACCEPTED)
    @PutMapping("/edit")
    public Model update(@RequestBody final ModelRequestDTO requestDTO) {
        return modelGateway.update(requestDTO);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("delete/{id}")
    public void delete(final @PathVariable Long id) {
        modelGateway.delete(id);
    }

}
