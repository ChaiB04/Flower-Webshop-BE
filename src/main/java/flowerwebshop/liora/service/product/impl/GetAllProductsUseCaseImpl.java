package flowerwebshop.liora.service.product.impl;

import flowerwebshop.liora.domain.Product;
import flowerwebshop.liora.repository.ProductRepository;
import flowerwebshop.liora.repository.converter.ProductEntityConverter;
import flowerwebshop.liora.service.product.GetAllProductsUseCase;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class GetAllProductsUseCaseImpl implements GetAllProductsUseCase {
    private ProductRepository productRepository;

    public Page<Product> getAllProducts(int page, int size) {

        Pageable pageable = PageRequest.of(page - 1, size, Sort.by(Sort.Direction.DESC, "id"));

        return productRepository.findAll(pageable).map(ProductEntityConverter::convertProductEntityToProduct);
    }
}
