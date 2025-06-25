package flowerwebshop.liora.domain;

import flowerwebshop.liora.domain.enums.ProductCategory;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private Date date_created;
    private String flower_category;
    private ProductCategory product_category;
    private boolean archived;
    private String meaning;
    private int stock;
}