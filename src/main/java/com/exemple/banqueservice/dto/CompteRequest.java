package com.exemple.banqueservice.dto;

import com.exemple.banqueservice.entities.TypeCompte;

import lombok.Data;

@Data
public class CompteRequest {
    private double solde;
    private String dateCreation;
    private TypeCompte type;
}
