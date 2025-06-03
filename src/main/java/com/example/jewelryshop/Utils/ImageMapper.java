package com.example.jewelryshop.Utils;

import com.example.jewelryshop.Dto.ImageDto;
import com.example.jewelryshop.Entity.ImageEntity;

public class ImageMapper {

    public ImageDto toImageDto(ImageEntity imageEntity) {
        ImageDto imageDto = new ImageDto();
        imageDto.setImage(imageEntity.getImage());
        return imageDto;
    }

    public ImageEntity toImageEntity(ImageDto imageDto) {
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setImage(imageDto.getImage());
        return imageEntity;
    }
}
