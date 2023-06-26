package com.example.reactback.controller.DTOS;

public record ModelResponseDTO(
        String name,
        String email,
        String login,
        String  password,
        String passwordConfirmation){
}
