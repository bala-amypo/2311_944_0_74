package com.example.demo.newentity;

import jakarta.persistence.*;
import jakarta.validation. constraints.NotBlank;
import jakarta. validation. constraints. Email;

public class NewfileEntity{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message="Should not contain spaces")
    private String name;
    @NotBlank(message="no blank spaces")
    @Email(message="invalid")
    private String email;
    public NewfileEntity(Long id, @NotBlank(message = "Should not contain spaces") String name,
            @NotBlank(message = "no blank spaces") @Email(message = "invalid") String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public NewfileEntity() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}