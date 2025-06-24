package flowerwebshop.liora.controller.dto;

import flowerwebshop.liora.domain.Product;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
@Builder
public class GetAllProductsResponse {
    private Page<Product> products;
}
