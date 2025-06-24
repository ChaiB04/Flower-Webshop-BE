package flowerwebshop.liora.repository.converter;

import flowerwebshop.liora.domain.Product;
import flowerwebshop.liora.domain.enums.ProductCategory;
import flowerwebshop.liora.repository.entity.ProductEntity;

public class ProductEntityConverter {

    public static ProductEntity convertProductToProductEntity(Product product) {
        return ProductEntity.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .date_created(product.getDate_created())
                .active(product.isActive())
                .description(product.getDescription())
                .category(product.getCategory().toString())
                .build();
    }

    public static Product convertProductEntityToProduct(ProductEntity productEntity) {
        return Product.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .price(productEntity.getPrice())
                .date_created(productEntity.getDate_created())
                .active(productEntity.isActive())
                .description(productEntity.getDescription())
                .category(ProductCategory.valueOf(productEntity.getCategory()))
                .build();
    }
}
