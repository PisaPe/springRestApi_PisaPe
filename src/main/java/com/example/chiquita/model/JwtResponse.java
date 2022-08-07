package com.example.chiquita.model;

import com.example.chiquita.entities.UserEntity;
import com.example.chiquita.responses.UserResponse;

public record JwtResponse(String jwtToken, String refreshToken, UserResponse user) {
}
