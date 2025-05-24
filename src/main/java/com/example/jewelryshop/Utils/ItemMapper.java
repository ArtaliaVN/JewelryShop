package com.example.jewelryshop.Utils;

import com.example.jewelryshop.Dto.ItemRequestDto;
import com.example.jewelryshop.Dto.ItemResponseDto;
import com.example.jewelryshop.Entity.ItemEntity;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public List<ItemResponseDto> toUserResponseDto(List<ItemEntity> itemEntities) {
        return itemEntities
                .stream()
                .map(this::toItemResponseDto)
                .toList();
    }
}
