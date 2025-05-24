package com.example.jewelryshop.Utils;

import com.example.jewelryshop.Dto.CartResponseDto;
import com.example.jewelryshop.Entity.CartEntity;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {
    public CartResponseDto toCartResponseDto(CartEntity cartEntity) {
        CartResponseDto cartResponseDto = new CartResponseDto();
        cartResponseDto.setQuantity(cartEntity.getQuantity());
        cartResponseDto.setPriceSum(cartEntity.getPriceSum());
        cartResponseDto.setOwner(cartEntity.getOwner());
        cartResponseDto.setOwnerId(cartEntity.getOwnerId());
        cartResponseDto.setItems(cartEntity.getItems());
        return cartResponseDto;
    }
}
