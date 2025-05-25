package com.example.jewelryshop.Utils;

import com.example.jewelryshop.Dto.UserPagingDto;
import com.example.jewelryshop.Dto.UserRequestDto;
import com.example.jewelryshop.Dto.UserResponseDto;
import com.example.jewelryshop.Entity.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserResponseDto toUserResponseDto(UserEntity userEntity) {
        UserResponseDto response = new UserResponseDto();
        response.setId(userEntity.getId());
        response.setEmail(userEntity.getEmail());
        response.setUsername(userEntity.getUsername());
        response.setFirstName(userEntity.getFirstName());
        response.setLastName(userEntity.getLastName());
        response.setRatedItem(userEntity.getRatedItem());
        return response;
    }

    public UserEntity toUserEntity(UserRequestDto responseDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(responseDto.getEmail());
        userEntity.setUsername(responseDto.getUsername());
        userEntity.setFirstName(responseDto.getFirstName());
        userEntity.setLastName(responseDto.getLastName());
        userEntity.setPassword(responseDto.getPassword());
        return userEntity;
    }

    public UserPagingDto toUserPagingDto(Page<UserEntity> userEntities) {
        UserPagingDto userPagingDto = new UserPagingDto();
        userPagingDto.setItems(userEntities
                .getContent()
                .stream()
                .map(this::toUserResponseDto)
                .collect(Collectors.toList()));
        userPagingDto.setTotalItems(userEntities.getNumberOfElements());
        userPagingDto.setTotalPages(userEntities.getTotalPages());
        userPagingDto.setPageSize(userEntities.getSize());
        userPagingDto.setCurrentPage(userEntities.getNumber());
        return userPagingDto;
    }
}
