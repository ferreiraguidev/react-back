package com.example.reactback.gateway;


import com.example.reactback.controller.DTOS.ModelRequestDTO;
import com.example.reactback.mapper.ModelMapper;
import com.example.reactback.model.Model;
import com.example.reactback.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ModelGateway {

    private final ModelRepository repository;


    public Model save(Model model) {
        return repository.save(model);
    }

    public List<Model> listAll(){
        return repository.findAll();
    }

    public Model findById(final Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NullPointerException("Customize exception!"));
    }

    public Model update(final ModelRequestDTO requestDTO) {
        val byId = repository.findById(requestDTO.id());

        if (byId.isEmpty()) {
            throw new IllegalArgumentException("Coudnt find any correspondent id");
        }
        val model = ModelMapper.toDomain(requestDTO);

        return repository.save(model);
    }

//    public Model findByName(final String name) {
//        return repository.findByName(name);
//
//    }

    public void delete(final Long id) {
        repository.deleteById(id);
    }


    public Model findByLogin(final String login) {
        return repository.findByLoginIgnoreCase(login);
    }

}
