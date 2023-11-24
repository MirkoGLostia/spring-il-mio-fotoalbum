package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Lob
    private String message;
    private Boolean readMex;

    @ManyToOne
    private User userMessage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getReadMex() {
        return readMex;
    }

    public void setReadMex(Boolean readMex) {
        this.readMex = readMex;
    }

    public User getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(User userMessage) {
        this.userMessage = userMessage;
    }
}
