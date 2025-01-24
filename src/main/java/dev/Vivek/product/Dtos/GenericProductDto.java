package dev.Vivek.product.Dtos;

import dev.Vivek.product.Models.Product;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class GenericProductDto {
    private Long id;
    private String title;
    private int price;
    private String description;
    private String category;
    private String image;
    private int stock;


    public static GenericProductDto from(Product product) {
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(product.getId());
        genericProductDto.setTitle(product.getTitle());
        genericProductDto.setDescription(product.getDescription());
        return genericProductDto;
    }


    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public String getTitle() {
        return this.title;
    }

    @Generated
    public int getPrice() {
        return this.price;
    }

    @Generated
    public String getDescription() {
        return this.description;
    }

    @Generated
    public String getCategory() {
        return this.category;
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
    public void setId(final Long id) {
        this.id = id;
    }

    @Generated
    public void setTitle(final String title) {
        this.title = title;
    }

    @Generated
    public void setPrice(final int price) {
        this.price = price;
    }

    @Generated
    public void setDescription(final String description) {
        this.description = description;
    }

    @Generated
    public void setCategory(final String category) {
        this.category = category;
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