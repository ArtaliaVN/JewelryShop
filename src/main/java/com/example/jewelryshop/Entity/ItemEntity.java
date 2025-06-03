package com.example.jewelryshop.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import java.util.List;

@Data
@Entity
@Table(name = "item_entity")
@AllArgsConstructor
@NoArgsConstructor
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String name;

    private String description;

    @NotBlank
    private int price;

    @NotBlank
    @ColumnDefault("0")
    private int quantity;

    @OneToMany
    private List<ImageEntity> images;

    @ManyToOne(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "category_id"
    )
    private CategoryEntity category;

    @ColumnDefault("0")
    private Double rating;
}
