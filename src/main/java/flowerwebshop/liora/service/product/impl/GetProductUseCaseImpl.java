package flowerwebshop.liora.service.product.impl;

import flowerwebshop.liora.domain.Product;
import flowerwebshop.liora.repository.ProductRepository;
import flowerwebshop.liora.repository.converter.ProductEntityConverter;
import flowerwebshop.liora.repository.entity.ProductEntity;
import flowerwebshop.liora.service.exception.ProductNotFoundException;
import flowerwebshop.liora.service.product.GetProductUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetProductUseCaseImpl implements GetProductUseCase {

    @Autowired
    private ProductRepository productRepository;

    public Product get(int id) {
        Optional<ProductEntity> optionalEntity = productRepository.findById(id);
        if (optionalEntity.isEmpty()) {
            throw new ProductNotFoundException("Product with ID " + id + " not found");
        }
        return ProductEntityConverter.convertProductEntityToProduct(optionalEntity.get());
    }
}
