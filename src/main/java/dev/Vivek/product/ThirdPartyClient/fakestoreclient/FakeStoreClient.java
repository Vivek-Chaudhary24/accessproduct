package dev.Vivek.product.ThirdPartyClient.fakestoreclient;

import dev.Vivek.product.Dtos.FakeStoreProductDto;
import dev.Vivek.product.Dtos.GenericProductDto;
import dev.Vivek.product.Exception.ProductNotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreClient {
    private RestTemplateBuilder builder;

    FakeStoreClient(RestTemplateBuilder builder) {
        this.builder = builder;
    }

    final String Url = "https://fakestoreapi.com/products";

    public FakeStoreProductDto getProductById(Long id) throws ProductNotFoundException {
        final String specificUrl = Url+"/{id}";
        RestTemplate restTemplate = builder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.getForEntity(specificUrl,FakeStoreProductDto.class,id);
        if(responseEntity.getBody() == null){
            throw new ProductNotFoundException("Product with id "+id+" doesn't exist");
        }
        return responseEntity.getBody();
    }

    public List<FakeStoreProductDto> getAllProducts(){
        RestTemplate restTemplate = builder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity =
                restTemplate.getForEntity(Url,FakeStoreProductDto[].class);
        return List.of(responseEntity.getBody());
    }

    public FakeStoreProductDto deleteProductById(Long id) {
        final String specificUrl = Url+"/{id}";
        RestTemplate restTemplate = builder.build();
        RequestCallback requestCallback =
                restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.execute(specificUrl, HttpMethod.DELETE,requestCallback,responseExtractor,id);
            return responseEntity.getBody();
    }

    public GenericProductDto createProduct(GenericProductDto dto) {
       RestTemplate restTemplate = builder.build();
       ResponseEntity<GenericProductDto> responseEntity =
               restTemplate.postForEntity(Url,dto,GenericProductDto.class);
       return responseEntity.getBody();

    }
}