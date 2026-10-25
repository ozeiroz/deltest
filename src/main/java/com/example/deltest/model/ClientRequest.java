package com.example.deltest.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ClientRequest {
    @NotBlank
    @Size(max = 255)
    private String fullName;
    private String gender;

    public String getGender() {
        return gender;
    }

    public String getFullName() {
        return fullName;
    }
}
