package com.example.jewelryshop.Dto;

import com.example.jewelryshop.Entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponseDto {
    private long id;
    private String name;
    private String description;
    private int price;
    private int quantity;
    private Category category;
    private Double rating;
    private List<Byte[]> images;
}
