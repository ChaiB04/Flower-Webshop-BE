package flowerwebshop.liora.controller.dto;

import flowerwebshop.liora.domain.enums.ProductCategory;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class UpdateProductResponse {
    private int id;
    private String name;
    private String description;
    private double price;
    private ProductCategory category;
    private Date date;
    private boolean active;
}
