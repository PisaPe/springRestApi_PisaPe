package com.example.chiquita.responses;

import java.util.UUID;

public record UserResponse(UUID id, String firstName, String lastName, String email) {
}
