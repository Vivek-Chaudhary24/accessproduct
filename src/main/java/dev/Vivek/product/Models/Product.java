package dev.Vivek.product.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
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
    @ManyToOne
    @JoinColumn(name="category_id",nullable=false)
    @JsonBackReference
    private Category category;
    @OneToOne(cascade={CascadeType.REMOVE,CascadeType.PERSIST})
    private Price price;

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

    public void setPrice(final Price price) {
        this.price = price;
    }
    public Price getPrice() {
        return this.price;
    }
    public void setCategory(final Category category) {
        this.category = category;
    }
    public Category getCategory() {
        return this.category;
    }
}
