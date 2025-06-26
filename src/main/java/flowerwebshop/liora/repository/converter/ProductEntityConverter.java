package flowerwebshop.liora.repository.converter;

import flowerwebshop.liora.domain.Product;
import flowerwebshop.liora.domain.enums.ProductCategory;
import flowerwebshop.liora.repository.entity.ProductEntity;

public class ProductEntityConverter {

    public static ProductEntity convertProductToProductEntity(Product product) {
        return ProductEntity.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .meaning(product.getMeaning())
                .date_created(product.getDate_created())
                .stock(product.getStock())
                .product_category(product.getProduct_category().toString())
                .archived(product.isArchived())
                .flower_category(product.getFlower_category())
                .build();
    }

    public static Product convertProductEntityToProduct(ProductEntity productEntity) {
        return Product.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .date_created(productEntity.getDate_created())
                .price(productEntity.getPrice())
                .meaning(productEntity.getMeaning())
                .stock(productEntity.getStock())
                .product_category(ProductCategory.valueOf(productEntity.getProduct_category()))
                .archived(productEntity.isArchived())
                .flower_category(productEntity.getFlower_category())
                .build();
    }
}
