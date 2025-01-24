package dev.Vivek.product.Dtos;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class FakeStoreProductDto {
    private long id;
    private String title;
    private int price;
    private String category;
    private String description;
    private String image;

    @Generated
    public long getId() {
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
    public String getCategory() {
        return this.category;
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
    public void setId(final long id) {
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
    public void setCategory(final String category) {
        this.category = category;
    }

    @Generated
    public void setDescription(final String description) {
        this.description = description;
    }

    @Generated
    public void setImage(final String image) {
        this.image = image;
    }
}
