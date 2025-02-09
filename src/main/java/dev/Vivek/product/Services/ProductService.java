package dev.Vivek.product.Services;

import dev.Vivek.product.Dtos.GenericProductDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    GenericProductDto getProductById(String authToken, Long id) throws Exception;

    List<GenericProductDto> getAllProducts();

    GenericProductDto deleteProductById(Long id);

    GenericProductDto createProduct(GenericProductDto product);

}
