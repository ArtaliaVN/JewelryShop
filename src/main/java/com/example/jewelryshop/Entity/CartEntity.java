package com.example.jewelryshop.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Entity
@Table(name = "cart_entity")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ColumnDefault("0")
    private int quantity;

    private double priceSum;

    @OneToOne
    @JoinColumn(
            name = "owner_id"
    )
    private UserEntity owner;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<ItemEntity> items;
}
