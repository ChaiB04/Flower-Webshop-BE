package flowerwebshop.liora.service.product;

import flowerwebshop.liora.domain.Product;
import org.springframework.data.domain.Page;

public interface GetAllProductsUseCase {
    Page<Product> getAllProducts(int page, int size);
}
