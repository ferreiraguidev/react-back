package com.example.reactback.repository;

import com.example.reactback.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {

    Model findByLoginIgnoreCase(String login);
}
