package com.example.jewelryshop.Dto;

import com.example.jewelryshop.Entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequestDto {
    private String name;
    private String description;
    private int price;
    private int quantity;
    private Category category;
    private List<Byte[]> images;
}
