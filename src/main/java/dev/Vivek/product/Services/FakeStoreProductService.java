package dev.Vivek.product.Services;

import dev.Vivek.product.Dtos.FakeStoreProductDto;
import dev.Vivek.product.Dtos.GenericProductDto;
import dev.Vivek.product.ThirdPartyClient.fakestoreclient.FakeStoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    private final FakeStoreClient fakeStoreClient;

    public FakeStoreProductService(FakeStoreClient fakeStoreClient) {
        this.fakeStoreClient = fakeStoreClient;
    }

    private static GenericProductDto convertToGenericProductDto(FakeStoreProductDto fakeStoreProductDto) {
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        return genericProductDto;
    }

    @Override
    public GenericProductDto getProductById(Long id) throws Exception{

        FakeStoreProductDto fakeStoreProductDto = fakeStoreClient.getProductById(id);
        return FakeStoreProductService.convertToGenericProductDto(fakeStoreProductDto);

    }

    public List<GenericProductDto> getAllProducts() {
        List<FakeStoreProductDto> fakeStoreProductDtos = new ArrayList<>();
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
