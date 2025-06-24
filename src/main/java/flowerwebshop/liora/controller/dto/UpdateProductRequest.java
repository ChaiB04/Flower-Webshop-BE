package flowerwebshop.liora.controller.dto;

import flowerwebshop.liora.domain.enums.ProductCategory;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateProductRequest {
    private int id;
    private String name;
    private String description;
    private double price;
    private ProductCategory category;
    private boolean active;
}
