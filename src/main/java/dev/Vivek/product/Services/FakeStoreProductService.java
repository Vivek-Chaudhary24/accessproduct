package dev.Vivek.product.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.Vivek.product.Dtos.FakeStoreProductDto;
import dev.Vivek.product.Dtos.GenericProductDto;
import dev.Vivek.product.ThirdPartyClient.fakestoreclient.FakeStoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
//import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Primary
@Service
public class FakeStoreProductService implements ProductService {

    private final FakeStoreClient fakeStoreClient;


  //  private RedisTemplate<String, FakeStoreProductDto> redisTemplate;

    public FakeStoreProductService(FakeStoreClient fakeStoreClient) {
        this.fakeStoreClient = fakeStoreClient;
    //    this.redisTemplate = redisTemplate;
    }

    private static GenericProductDto convertToGenericProductDto(FakeStoreProductDto fakeStoreProductDto) {
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        return genericProductDto;
    }

    @Override
    public GenericProductDto getProductById(String authToken,Long id) throws Exception{

     //   FakeStoreProductDto fakeStoreProductDto = (FakeStoreProductDto) redisTemplate.opsForHash().get("PRODUCTS",String.valueOf(id));
      //  Object fakeStoreProductDto =  redisTemplate.opsForHash().get("PRODUCTS",String.valueOf(id));

//        if(fakeStoreProductDto != null){
//          FakeStoreProductDto cachedProduct=     new ObjectMapper().convertValue(fakeStoreProductDto, FakeStoreProductDto.class);
//                  return convertToGenericProductDto(cachedProduct);
//              }

        FakeStoreProductDto fakeStoreProductDtos = fakeStoreClient.getProductById(id);
//           redisTemplate.opsForHash().put("PRODUCTS",String.valueOf(id),fakeStoreProductDtos);
        return FakeStoreProductService.convertToGenericProductDto(fakeStoreProductDtos);

    }

    public List<GenericProductDto> getAllProducts() {
        List<FakeStoreProductDto> fakeStoreProductDtos;
        fakeStoreProductDtos = fakeStoreClient.getAllProducts();
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            genericProductDtos.add(FakeStoreProductService.convertToGenericProductDto(fakeStoreProductDto));
        }
        return genericProductDtos;
    }

    public GenericProductDto deleteProductById(Long id) {
        FakeStoreProductDto fakeStoreProductDto = fakeStoreClient.deleteProductById(id);
        return FakeStoreProductService.convertToGenericProductDto(fakeStoreProductDto);

    }

    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        GenericProductDto genericProductDto1 = fakeStoreClient.createProduct(genericProductDto);
        return genericProductDto1;
    }
}
