package com.example.jewelryshop.Dto;

import com.example.jewelryshop.Entity.ItemEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartResponseDto {
    private int quantity;
    private double priceSum;
    private String owner;
    private long ownerId;
    private List<ItemEntity> items;
}
