package dev.Vivek.product.Controllers;

import dev.Vivek.product.Dtos.GenericProductDto;
import dev.Vivek.product.Services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable ("id") Long id) throws Exception {

        return productService.getProductById(id);


    }

    @GetMapping
    public List<GenericProductDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public GenericProductDto deleteProductById(@PathVariable ("id") Long id){
        return productService.deleteProductById(id);
    }
    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto){
        return productService.createProduct(genericProductDto);
    }


    public String game(){
        return "Vivo1";
    }
}
