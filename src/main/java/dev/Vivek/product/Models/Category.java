package dev.Vivek.product.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseModel{
    private String name;

    @OneToMany(fetch=jakarta.persistence.FetchType.EAGER,mappedBy = "category")
    @JsonIgnore
    private List<Product> products;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

}
