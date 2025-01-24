package dev.Vivek.product.Models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;


@Data
@Entity
public class Product extends BaseModel{
    private String title;
    private String description;
    private String image;
    private int stock;

    @Generated
    public String getTitle() {
        return this.title;
    }

    @Generated
    public String getDescription() {
        return this.description;
    }

    @Generated
    public String getImage() {
        return this.image;
    }

    @Generated
    public int getStock() {
        return this.stock;
    }

    @Generated
    public void setTitle(final String title) {
        this.title = title;
    }

    @Generated
    public void setDescription(final String description) {
        this.description = description;
    }

    @Generated
    public void setImage(final String image) {
        this.image = image;
    }

    @Generated
    public void setStock(final int stock) {
        this.stock = stock;
    }

}
