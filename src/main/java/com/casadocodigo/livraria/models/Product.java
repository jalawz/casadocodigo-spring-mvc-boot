package com.casadocodigo.livraria.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Lob
    private String description;

    private Integer pages;

    @ElementCollection
    private List<Price> prices = new ArrayList<>();
}
