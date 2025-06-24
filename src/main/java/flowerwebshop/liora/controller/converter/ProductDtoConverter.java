package flowerwebshop.liora.controller.converter;

import flowerwebshop.liora.controller.dto.*;
import flowerwebshop.liora.domain.Product;

public class ProductDtoConverter {

    public static CreateProductResponse domainToCreateProductResponse(int id) {
        return CreateProductResponse.builder().id(id).build();
    }

    public static Product createProductDTOToProduct(CreateProductRequest request) {
        return Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .category(request.getCategory())
                .active(request.isActive())
                .build();
    }

    public static Product updateProductDTOToProduct(UpdateProductRequest request) {
        return Product.builder()
                .id(request.getId())
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .category(request.getCategory())
                .active(request.isActive())
                .build();
    }

    public static UpdateProductResponse productToUpdateProductDTO(Product product) {
        return UpdateProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .date(product.getDate_created())
                .category(product.getCategory())
                .active(product.isActive())
                .build();
    }

    public static GetProductResponse productToGetProductDTO(Product product) {
        return GetProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .category(product.getCategory())
                .date_created(product.getDate_created())
                .active(product.isActive())
                .build();
    }
}
