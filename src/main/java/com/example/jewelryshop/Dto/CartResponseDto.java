package com.example.jewelryshop.Dto;

import com.example.jewelryshop.Entity.ItemEntity;
import com.example.jewelryshop.Entity.UserEntity;
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
    private UserEntity owner;
    private List<ItemEntity> items;
}
