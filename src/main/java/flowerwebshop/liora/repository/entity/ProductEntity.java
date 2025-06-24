package flowerwebshop.liora.repository.entity;


import flowerwebshop.liora.domain.enums.ProductCategory;
import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotNull;


import java.util.Date;

@Entity
@Table(name = "product")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @NotNull
    @Column(name = "date")
    String name;

    @NotNull
    @Column(name = "description")
    String description;

    @NotNull
    @Column(name = "price")
    double price;

    @NotNull
    @Column(name = "date_created")
    Date date_created;

    @NotNull
    @Column(name = "category")
    String category;

    @NotNull
    @Column(name = "active")
    boolean active;
}
