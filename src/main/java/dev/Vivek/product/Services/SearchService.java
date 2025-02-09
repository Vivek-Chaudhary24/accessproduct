package dev.Vivek.product.Services;

import dev.Vivek.product.Dtos.GenericProductDto;
import dev.Vivek.product.Models.Product;
import dev.Vivek.product.Models.SearchRequestDto;
import dev.Vivek.product.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {


    private ProductRepository productRepository;


    SearchService(ProductRepository productRepository) {
    this.productRepository = productRepository;
    }

    public List<GenericProductDto> searchProducts(SearchRequestDto request){
        List<GenericProductDto> products = new ArrayList<>();
            Sort sort =null;
            if(request.getSortParams().get(0).getSortType().equalsIgnoreCase("ASC")){
                sort = Sort.by(request.getSortParams().get(0).getSortParamName()).ascending();
            }
            else{
                sort=Sort.by(request.getSortParams().get(0).getSortParamName()).descending();
            }

            for(int i =1; i< request.getSortParams().size();i++){
                if(request.getSortParams().get(i).getSortType().equalsIgnoreCase("ASC")){
                    sort.and(Sort.by(request.getSortParams().get(i).getSortParamName()).ascending());
                }
                else{
                    sort.and(Sort.by(request.getSortParams().get(i).getSortParamName()).descending());
                }

            }

            PageRequest pageRequest = PageRequest.of(request.getPageNumber(),request.getPageSize(),sort);
            List<Product> product = productRepository.findAllByTitleContainingIgnoreCase(request.getTitle(),pageRequest);
        for(Product prod : product){
            products.add(GenericProductDto.from(prod));
        }

        return products;
    }

}
