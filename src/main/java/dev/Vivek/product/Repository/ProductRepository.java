package dev.Vivek.product.Repository;

import dev.Vivek.product.Dtos.GenericProductDto;
import dev.Vivek.product.Models.Product;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Long> {
    List<Product> findAllByTitleContainingIgnoreCase(String title, PageRequest pageRequest);

    List<Product> findAllById(Long id);
}
