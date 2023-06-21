package com.example.reactback.gateway;


import com.example.reactback.model.Model;
import com.example.reactback.repository.ModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelGateway {

    private final ModelRepository repository;

    public ModelGateway(ModelRepository repository) {
        this.repository = repository;
    }

    public Model save(Model model) {
        return repository.save(model);
    }

    public List<Model> listAll(){
        return repository.findAll();
    }
}
