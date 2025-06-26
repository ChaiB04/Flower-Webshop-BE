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
                .meaning(request.getMeaning())
                .stock(request.getStock())
                .product_category(request.getProduct_category())
                .archived(request.isArchived())
                .flower_category(request.getFlower_category())
                .build();
    }

    public static Product updateProductDTOToProduct(UpdateProductRequest request) {
        return Product.builder()
                .id(request.getId())
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .meaning(request.getMeaning())
                .stock(request.getStock())
                .date_created(request.getDate_created())
                .product_category(request.getProduct_category())
                .archived(request.isArchived())
                .flower_category(request.getFlower_category())
                .build();
    }

    public static UpdateProductResponse productToUpdateProductDTO(Product product) {
        return UpdateProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .meaning(product.getMeaning())
                .stock(product.getStock())
                .date_created(product.getDate_created())
                .product_category(product.getProduct_category())
                .archived(product.isArchived())
                .flower_category(product.getFlower_category())
                .build();
    }

    public static GetProductResponse productToGetProductDTO(Product product) {
        return GetProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .meaning(product.getMeaning())
                .stock(product.getStock())
                .date_created(product.getDate_created())
                .product_category(product.getProduct_category())
                .archived(product.isArchived())
                .flower_category(product.getFlower_category())
                .build();
    }
}
