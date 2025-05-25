package com.example.jewelryshop.Utils;

import com.example.jewelryshop.Dto.ItemPagingDto;
import com.example.jewelryshop.Dto.ItemRequestDto;
import com.example.jewelryshop.Dto.ItemResponseDto;
import com.example.jewelryshop.Entity.ItemEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ItemMapper {

    public ItemResponseDto toItemResponseDto(ItemEntity itemEntity) {
        ItemResponseDto itemResponseDto = new ItemResponseDto();
        itemResponseDto.setId(itemEntity.getId());
        itemResponseDto.setName(itemEntity.getName());
        itemResponseDto.setPrice(itemEntity.getPrice());
        itemResponseDto.setQuantity(itemEntity.getQuantity());
        itemResponseDto.setCategory(itemEntity.getCategory());
        itemResponseDto.setDescription(itemEntity.getDescription());
        itemResponseDto.setRating(itemEntity.getRating());
        return itemResponseDto;
    }

    public ItemEntity toItemEntity(ItemRequestDto itemResponseDto) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setName(itemResponseDto.getName());
        itemEntity.setPrice(itemResponseDto.getPrice());
        itemEntity.setQuantity(itemResponseDto.getQuantity());
        itemEntity.setCategory(itemResponseDto.getCategory());
        itemEntity.setDescription(itemResponseDto.getDescription());
        return itemEntity;
    }

    public ItemPagingDto toItemPagingDto(Page<ItemEntity> itemEntities) {
        ItemPagingDto itemPagingDto = new ItemPagingDto();
        itemPagingDto.setItems(itemEntities
                .getContent()
                .stream()
                .map(this::toItemResponseDto)
                .collect(Collectors.toList()));
        itemPagingDto.setTotalItems(itemEntities.getNumberOfElements());
        itemPagingDto.setTotalPages(itemEntities.getTotalPages());
        itemPagingDto.setPageSize(itemEntities.getSize());
        itemPagingDto.setCurrentPage(itemEntities.getNumber());
        return itemPagingDto;
    }
}
