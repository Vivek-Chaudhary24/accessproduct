package dev.Vivek.product.Controllers;

import dev.Vivek.product.Dtos.GenericProductDto;
import dev.Vivek.product.Services.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    @Value("${server.port}")
    private String port;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/{id}")
    public GenericProductDto getProductById(String authToken, @PathVariable ("id") Long id) throws Exception {
           System.out.println("In productservice"+port);
        return productService.getProductById(authToken,id);


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

    @GetMapping("/ch")
    public String game(){
        return "Vivo1";
    }
}
