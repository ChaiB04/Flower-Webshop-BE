package flowerwebshop.liora.service.product.impl;

import flowerwebshop.liora.domain.Product;
import flowerwebshop.liora.repository.ProductRepository;
import flowerwebshop.liora.repository.converter.ProductEntityConverter;
import flowerwebshop.liora.service.product.CreateProductUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class CreateProductUseCaseImpl implements CreateProductUseCase {

    @Autowired
    private ProductRepository productRepository;

    public int create(Product product) {
        product.setDate_created(new Date());

        return productRepository.save(ProductEntityConverter.convertProductToProductEntity(product)).getId();
    }
}
