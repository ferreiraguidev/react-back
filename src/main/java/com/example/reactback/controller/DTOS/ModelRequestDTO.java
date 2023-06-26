package com.example.reactback.controller.DTOS;

public record ModelRequestDTO (
        Long id,
        String name,
       String email,
       String login,
       String  password,
       String passwordConfirmation){
}
