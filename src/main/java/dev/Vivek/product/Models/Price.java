package dev.Vivek.product.Models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Price extends BaseModel{

    private String currency;
    private double value;

}
