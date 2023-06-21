package com.example.reactback.repository;

import com.example.reactback.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {

}
