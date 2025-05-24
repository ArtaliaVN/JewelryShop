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
@Table(schema = "item_entity")
@AllArgsConstructor
@NoArgsConstructor
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(max = 50)
    private String name;

    private String description;

    @NotBlank
    private int price;

    @NotBlank
    @ColumnDefault("0")
    private int quantity;

    private List<Byte[]> images;

    private Category category;

    @ColumnDefault("0")
    private Double rating;
}
