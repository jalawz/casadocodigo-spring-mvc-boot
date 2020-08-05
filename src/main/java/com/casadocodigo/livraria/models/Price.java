package com.casadocodigo.livraria.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
@Getter
@Setter
public class Price {

    @Column(scale = 2)
    private BigDecimal value;

    private BookType bookType;
}
