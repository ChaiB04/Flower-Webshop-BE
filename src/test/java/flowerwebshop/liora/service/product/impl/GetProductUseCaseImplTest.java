package flowerwebshop.liora.service.product.impl;

import flowerwebshop.liora.domain.Product;
import flowerwebshop.liora.domain.enums.ProductCategory;
import flowerwebshop.liora.repository.ProductRepository;
import flowerwebshop.liora.repository.entity.ProductEntity;
import flowerwebshop.liora.service.exception.ProductNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetProductUseCaseImplTest {
    @InjectMocks
    private GetProductUseCaseImpl getProductUseCase;

    @Mock
    private ProductRepository productRepository;

    @Test
    void getProductById_ProductExists_ReturnsProduct() {
        int productId = 1;
        ProductEntity entity = ProductEntity.builder()
                .id(productId)
                .name("Tulip Garden")
                .description("A field of tulips.")
                .price(24.99)
                .date_created(new Date())
                .product_category(String.valueOf(ProductCategory.BOUQUET))
                .flower_category("Lavender")
                .archived(false)
                .stock(23)
                .meaning("Love, unforgettable")
                .build();

        when(productRepository.findById(productId)).thenReturn(Optional.of(entity));

        Product result = getProductUseCase.get(productId);

        assertNotNull(result);
        assertEquals(productId, result.getId());
        assertEquals("Tulip Garden", result.getName());
        verify(productRepository).findById(productId);
    }

    @Test
    void getProductById_ProductDoesNotExist_ThrowsException() {
        int productId = 999;
        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        ProductNotFoundException thrown = assertThrows(
                ProductNotFoundException.class,
                () -> getProductUseCase.get(productId)
        );

        assertEquals("Product with ID 999 not found", thrown.getMessage());
        verify(productRepository).findById(productId);
    }


}