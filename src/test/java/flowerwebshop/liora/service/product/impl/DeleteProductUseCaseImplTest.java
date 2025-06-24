package flowerwebshop.liora.service.product.impl;

import flowerwebshop.liora.repository.ProductRepository;
import flowerwebshop.liora.repository.entity.ProductEntity;
import flowerwebshop.liora.service.exception.ProductNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeleteProductUseCaseImplTest {
    @InjectMocks
    private DeleteProductUseCaseImpl createProductUseCase;

    @Mock
    private ProductRepository productRepository;
    @Test
    void deleteProduct_Successful() {
        int productId = 1;
        ProductEntity entity = ProductEntity.builder().id(productId).build();

        when(productRepository.findById(productId)).thenReturn(Optional.of(entity));

        createProductUseCase.delete(productId);

        verify(productRepository).findById(productId);
        verify(productRepository).deleteById(productId);
    }

    @Test
    void deleteProduct_NotFound_ThrowsException() {
        int productId = 999;

        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        ProductNotFoundException exception = assertThrows(
                ProductNotFoundException.class,
                () -> createProductUseCase.delete(productId)
        );

        assertEquals("Product with ID 999 not found", exception.getMessage());

        verify(productRepository).findById(productId);
    }


}