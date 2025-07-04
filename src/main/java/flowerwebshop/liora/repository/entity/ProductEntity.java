package flowerwebshop.liora.repository.entity;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotNull;


import java.util.Date;
import java.util.List;

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
    @Column(name = "name")
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
    @Column(name = "flower_category")
    String flower_category;

    @NotNull
    @Column(name = "product_category")
    String product_category;

    @NotNull
    @Column(name = "archived")
    boolean archived;

    @NotNull
    @Column(name = "meaning")
    String meaning;


    @NotNull
    @Column(name = "stock")
    int stock;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "product", fetch = FetchType.EAGER)
    private List<PictureEntity> pictures;
}

