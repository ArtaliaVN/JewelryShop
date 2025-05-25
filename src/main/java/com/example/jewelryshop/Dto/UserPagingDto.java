package com.example.jewelryshop.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPagingDto {
    private long totalItems;
    private int totalPages;
    private int currentPage;
    private int pageSize;
    private List<UserResponseDto> items;
}
