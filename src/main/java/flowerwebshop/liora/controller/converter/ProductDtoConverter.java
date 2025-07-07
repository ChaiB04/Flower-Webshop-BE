package flowerwebshop.liora.controller.converter;

import flowerwebshop.liora.controller.dto.*;
import flowerwebshop.liora.domain.Product;

import java.util.Base64;
import java.util.List;

public class ProductDtoConverter {

    public static CreateProductResponse domainToCreateProductResponse(int id) {
        return CreateProductResponse.builder().id(id).build();
    }

    public static Product createProductDTOToProduct(CreateProductRequest request) {
        List<byte[]> decodedPhotos = request.getPhotos().stream()
                .map(photoBase64 -> Base64.getDecoder().decode(photoBase64))
                .toList();


        return Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .meaning(request.getMeaning())
                .stock(request.getStock())
                .product_category(request.getProduct_category())
                .archived(request.isArchived())
                .photos(decodedPhotos)
                .flower_category(request.getFlower_category())
                .build();
    }

    public static Product updateProductDTOToProduct(UpdateProductRequest request) {
        List<byte[]> decodedPhotos = request.getPhotos().stream()
                .map(photoBase64 -> Base64.getDecoder().decode(photoBase64))
                .toList();

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
                .photos(decodedPhotos)
                .flower_category(request.getFlower_category())
                .build();
    }

    public static UpdateProductResponse productToUpdateProductDTO(Product product) {
        List<String> encodedPhotos = product.getPhotos().stream()
                .map(photo -> Base64.getEncoder().encodeToString(photo))
                .toList();


        return UpdateProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .meaning(product.getMeaning())
                .stock(product.getStock())
                .photos(encodedPhotos)
                .date_created(product.getDate_created())
                .product_category(product.getProduct_category())
                .archived(product.isArchived())
                .flower_category(product.getFlower_category())
                .build();
    }

    public static GetProductResponse productToGetProductDTO(Product product) {
        List<String> encodedPhotos = product.getPhotos().stream()
                .map(photo -> Base64.getEncoder().encodeToString(photo))
                .toList();

        return GetProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .meaning(product.getMeaning())
                .stock(product.getStock())
                .photos(encodedPhotos)
                .date_created(product.getDate_created())
                .product_category(product.getProduct_category())
                .archived(product.isArchived())
                .flower_category(product.getFlower_category())
                .build();
    }
}
