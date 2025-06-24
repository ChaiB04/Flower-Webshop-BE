package flowerwebshop.liora.service.product.impl;

import flowerwebshop.liora.domain.Product;
import flowerwebshop.liora.domain.enums.ProductCategory;
import flowerwebshop.liora.repository.ProductRepository;
import flowerwebshop.liora.repository.entity.ProductEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetAllProductsUseCaseImplTest {
    @InjectMocks
    private GetAllProductsUseCaseImpl getAllProductsUseCase;

    @Mock
    private ProductRepository productRepository;

    @Test
    void getAllProducts_ReturnsPagedProducts() {
        int page = 1;
        int size = 2;

        Pageable pageable = PageRequest.of(0, size, Sort.by(Sort.Direction.ASC, "id"));

        ProductEntity entity1 = ProductEntity.builder()
                .id(1)
                .name("Product 1")
                .category(ProductCategory.BOUQUET.name())
                .build();

        ProductEntity entity2 = ProductEntity.builder()
                .id(2)
                .name("Product 2")
                .category(ProductCategory.BOUQUET.name())
                .build();


        List<ProductEntity> entityList = Arrays.asList(entity1, entity2);
        Page<ProductEntity> entityPage = new PageImpl<>(entityList, pageable, entityList.size());

        when(productRepository.findAll(pageable)).thenReturn(entityPage);

        Page<Product> resultPage = getAllProductsUseCase.getAllProducts(page, size);

        assertEquals(2, resultPage.getContent().size());
        assertEquals("Product 1", resultPage.getContent().get(0).getName());
        assertEquals("Product 2", resultPage.getContent().get(1).getName());

        verify(productRepository).findAll(pageable);
    }

}