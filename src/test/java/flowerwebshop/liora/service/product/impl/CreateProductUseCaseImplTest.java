package flowerwebshop.liora.service.product.impl;

import flowerwebshop.liora.domain.Product;
import flowerwebshop.liora.domain.enums.ProductCategory;
import flowerwebshop.liora.repository.ProductRepository;
import flowerwebshop.liora.repository.converter.ProductEntityConverter;
import flowerwebshop.liora.repository.entity.ProductEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CreateProductUseCaseImplTest {

    @InjectMocks
    private CreateProductUseCaseImpl createProductUseCase;

    @Mock
    private ProductRepository productRepository;

    @Test
    void createProduct_Successful() {
        Date now = new Date();

        Product product = Product.builder()
                .id(1)
                .name("Lavender Bliss Bouquet")
                .description("A soothing blend of fresh lavender and wildflowers.")
                .price(34.99)
                .date_created(now)
                .product_category(ProductCategory.BOUQUET)
                .flower_category("Lavender")
                .archived(false)
                .stock(23)
                .meaning("Love, unforgettable")
                .build();


        ProductEntity expectedEntity = ProductEntityConverter.convertProductToProductEntity(product);

        when(productRepository.save(any(ProductEntity.class))).thenReturn(expectedEntity);

        int result = createProductUseCase.create(product);

        assertEquals(product.getId(), result);
        verify(productRepository).save(any(ProductEntity.class));
    }


}