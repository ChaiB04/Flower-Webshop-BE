package flowerwebshop.liora.controller.dto;

import flowerwebshop.liora.domain.enums.ProductCategory;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CreateProductRequest {
    private String name;
    private String description;
    private double price;
    private ProductCategory category;
    private boolean active;
}
