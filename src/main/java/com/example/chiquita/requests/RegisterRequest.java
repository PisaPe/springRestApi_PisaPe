package com.example.chiquita.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public record RegisterRequest(

        @NotEmpty(message = "First name is required")
        @Size(min = 2, max = 50, message = "First name must be in between 2 and 50 char")
        String firstName,

        @NotEmpty
        @Size(min = 2, max = 50)
        String lastName,

        @NotEmpty
        @Email
        String email,

        @NotEmpty
        @Size(min = 8, max = 100)
        String password
) {
}
