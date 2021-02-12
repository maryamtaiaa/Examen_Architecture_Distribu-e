package com.example.demo.entities;

import lombok.Data;

import javax.persistence.OneToMany;
import java.util.List;

@Data
public class Client {
    private Long code;
    private String nom;
    private String adresse;
}
