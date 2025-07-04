package flowerwebshop.liora.controller.dto;

import flowerwebshop.liora.domain.enums.ProductCategory;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class UpdateProductRequest {
    private int id;
    private String name;
    private String description;
    private double price;
    private Date date_created;
    private ProductCategory product_category;
    private String flower_category;
    private boolean archived;
    private List<String> photos;
    private String meaning;
    private int stock;
}
