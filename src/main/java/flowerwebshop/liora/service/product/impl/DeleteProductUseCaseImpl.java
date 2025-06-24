package flowerwebshop.liora.service.product.impl;

import flowerwebshop.liora.repository.ProductRepository;
import flowerwebshop.liora.repository.entity.ProductEntity;
import flowerwebshop.liora.service.exception.ProductNotFoundException;
import flowerwebshop.liora.service.product.DeleteProductUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DeleteProductUseCaseImpl implements DeleteProductUseCase {

    @Autowired
    private ProductRepository productRepository;

    public void delete(int id) {
        Optional<ProductEntity> productEntity = productRepository.findById(id);
        if (productEntity.isPresent()) {
            productRepository.deleteById(id);
        }
        else {
            throw new ProductNotFoundException("Product with ID " + id + " not found");
        }
    }
}
