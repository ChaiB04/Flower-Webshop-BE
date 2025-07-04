package flowerwebshop.liora.service.product.impl;

import flowerwebshop.liora.domain.Product;
import flowerwebshop.liora.repository.ProductRepository;
import flowerwebshop.liora.repository.converter.ProductEntityConverter;
import flowerwebshop.liora.repository.entity.ProductEntity;
import flowerwebshop.liora.service.exception.ProductNotFoundException;
import flowerwebshop.liora.service.product.UpdateProductUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UpdateProductUseCaseImpl implements UpdateProductUseCase {

    private final ProductRepository productRepository;

    @Override
    public Product update(Product product) {
        Optional<ProductEntity> optionalEntity = productRepository.findById(product.getId());

        if (optionalEntity.isEmpty()) {
            throw new ProductNotFoundException("Product with ID " + product.getId() + " not found");
        }

        ProductEntity entityToUpdate = optionalEntity.get();

        entityToUpdate.setName(product.getName());
        entityToUpdate.setDescription(product.getDescription());
        entityToUpdate.setPrice(product.getPrice());
        entityToUpdate.setFlower_category(product.getFlower_category());
        entityToUpdate.setProduct_category(product.getProduct_category().toString());
        entityToUpdate.setStock(product.getStock());
        entityToUpdate.setMeaning(product.getMeaning());
        entityToUpdate.setArchived(product.isArchived());

        ProductEntity savedEntity = productRepository.save(entityToUpdate);

        return ProductEntityConverter.convertProductEntityToProduct(savedEntity);
    }
}
