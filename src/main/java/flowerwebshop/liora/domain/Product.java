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
    private ProductCategory category;
    private boolean active;
}
