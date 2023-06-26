package com.example.reactback.gateway;


import com.example.reactback.controller.DTOS.ModelRequestDTO;
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

    public List<Model> listAll() {
        return repository.findAll();
    }

    public Model findById(final Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NullPointerException("Customize exception!"));
    }

    public Model update(final ModelRequestDTO requestDTO) {
        val byId = repository.findById(requestDTO.id());

        if (byId.isEmpty()) {
            throw new IllegalArgumentException("ID inexistente!");
        }

        val model = Model.builder()
                .id(requestDTO.id())
                .name(requestDTO.name())
                .login(requestDTO.login())
                .email(requestDTO.email())
                .password(requestDTO.password())
                .passwordConfirmation(requestDTO.passwordConfirmation())
                .build();
        return repository.save(model);
    }

    public void delete(final Long id) {
        repository.deleteById(id);
    }

    // same as FindByName - in order to update
    public Model findByLogin(final String login) {
        return repository.findByLoginIgnoreCase(login);
    }

}
