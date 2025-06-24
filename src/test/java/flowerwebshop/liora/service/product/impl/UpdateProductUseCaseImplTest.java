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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UpdateProductUseCaseImplTest {

    @InjectMocks
    private UpdateProductUseCaseImpl updateProductUseCase;

    @Mock
    private ProductRepository productRepository;


    @Test
    void updateProduct_ProductExists_UpdatesAndReturnsProduct() {

        int productId = 1;

        ProductEntity existingEntity = ProductEntity.builder()
                .id(productId)
                .name("Old Name")
                .description("Old Desc")
                .price(20.0)
                .category(ProductCategory.BOUQUET.name())
                .active(true)
                .date_created(new Date())
                .build();

        Product updatedProduct = Product.builder()
                .id(productId)
                .name("New Name")
                .description("New Desc")
                .price(30.0)
                .category(ProductCategory.ACCESSORY)
                .active(false)
                .date_created(new Date())
                .build();

        ProductEntity updatedEntity = ProductEntity.builder()
                .id(productId)
                .name("New Name")
                .description("New Desc")
                .price(30.0)
                .category(ProductCategory.ACCESSORY.name())
                .active(false)
                .date_created(existingEntity.getDate_created())
                .build();

        when(productRepository.findById(productId)).thenReturn(Optional.of(existingEntity));
        when(productRepository.save(any(ProductEntity.class))).thenReturn(updatedEntity);

        Product result = updateProductUseCase.update(updatedProduct);

        assertNotNull(result);
        assertEquals(updatedProduct.getName(), result.getName());
        assertEquals(updatedProduct.getDescription(), result.getDescription());
        assertEquals(updatedProduct.getPrice(), result.getPrice());
        assertEquals(updatedProduct.getCategory(), result.getCategory());
        assertFalse(result.isActive());

        verify(productRepository).findById(productId);
        verify(productRepository).save(any(ProductEntity.class));
    }

    @Test
    void updateProduct_ProductDoesNotExist_ThrowsException() {

        Product productToUpdate = Product.builder()
                .id(999)
                .name("Doesn't matter")
                .description("Still doesn't matter")
                .price(10.0)
                .category(ProductCategory.BOUQUET)
                .active(true)
                .build();

        when(productRepository.findById(999)).thenReturn(Optional.empty());

        ProductNotFoundException thrown = assertThrows(
                ProductNotFoundException.class,
                () -> updateProductUseCase.update(productToUpdate)
        );

        assertEquals("Product with ID 999 not found", thrown.getMessage());
        verify(productRepository).findById(999);
    }


}