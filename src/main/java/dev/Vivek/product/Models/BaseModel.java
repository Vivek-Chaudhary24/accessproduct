package dev.Vivek.product.Models;

import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Data
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public void setId(final Long id) {
        this.id = id;
    }
}