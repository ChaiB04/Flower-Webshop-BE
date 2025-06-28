package flowerwebshop.liora.controller.dto;

import flowerwebshop.liora.domain.enums.ProductCategory;
import jakarta.validation.constraints.NotNull;
import jakarta.websocket.OnError;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateProductRequest {

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private double price;

    @NotNull
    private ProductCategory product_category;

    @NotNull
    private String flower_category;
    private boolean archived;

    @NotNull
    private String meaning;
    @NotNull
    private int stock;
}