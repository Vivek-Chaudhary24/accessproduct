package dev.Vivek.product.Services;

import dev.Vivek.product.Dtos.GenericProductDto;
import dev.Vivek.product.Exception.ProductNotFoundException;
import dev.Vivek.product.Models.Category;
import dev.Vivek.product.Models.Product;
import dev.Vivek.product.Repository.CategoryRepository;
import dev.Vivek.product.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class SelfProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    private RestTemplate builder;

//    @Autowired
//    SelfProductServiceImpl(ProductRepository productRepository , RestTemplate builder) {
//
//        this.productRepository = productRepository;
//        this.builder = builder;
//    }

    @Override
    public GenericProductDto getProductById(String authToken,Long id) throws Exception {
        GenericProductDto genericProductDto = new GenericProductDto();
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product not found");
        }
        Product product = productOptional.get();
        //Category category = categoryRepository.findById(product.getCategory().getId()).get();
        genericProductDto.setDescription(product.getDescription());
        genericProductDto.setId(product.getId());
        genericProductDto.setTitle(product.getTitle());
        genericProductDto.setStock(product.getStock());
        genericProductDto.setCategory(product.getCategory());
        return genericProductDto;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
           GenericProductDto genericProductDto = new GenericProductDto();
            genericProductDto.setTitle(product.getTitle());
            genericProductDto.setDescription(product.getDescription());
            genericProductDto.setId(product.getId());
            genericProductDto.setCategory(product.getCategory());
            genericProductDtos.add(genericProductDto);
        }
        return genericProductDtos;
    }
    @Override
    public GenericProductDto deleteProductById(Long id) {
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericproduct) {

        Category category = categoryRepository.findByName(genericproduct.getCategory().getName())
                .orElseGet(() -> {
                    Category newCategory = new Category();
                    newCategory.setName(genericproduct.getCategory().getName());
                    return categoryRepository.save(newCategory);
                        });
       // category.setId(genericproduct.getId());
//        category.setName(genericproduct.getCategory());
//        Category save = CategoryRepository.save(category);
        Product product = new Product();
        product.setDescription(genericproduct.getDescription());
        product.setStock(genericproduct.getStock());
        product.setTitle(genericproduct.getTitle());
        product.setCategory(category);
        productRepository.save(product);
        return genericproduct;
    }
}
