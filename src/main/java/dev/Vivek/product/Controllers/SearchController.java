package dev.Vivek.product.Controllers;

import dev.Vivek.product.Dtos.GenericProductDto;
import dev.Vivek.product.Models.SearchRequestDto;
import dev.Vivek.product.Services.SearchService;
//import org.hibernate.query.Page;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {


    private SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping
    public Page<GenericProductDto> searchProducts(@RequestBody SearchRequestDto request){
         List<GenericProductDto> genericProductDtoList = searchService.searchProducts(request);
         Page<GenericProductDto> genericProductDtoPage = new PageImpl<>(genericProductDtoList);
         return genericProductDtoPage;
    }
}