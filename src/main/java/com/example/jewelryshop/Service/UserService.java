package com.example.jewelryshop.Service;

import com.example.jewelryshop.Dto.UserPagingDto;
import com.example.jewelryshop.Dto.UserRequestDto;
import com.example.jewelryshop.Dto.UserResponseDto;
import com.example.jewelryshop.Entity.UserEntity;
import com.example.jewelryshop.Repo.UserRepo;
import com.example.jewelryshop.Utils.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserMapper userMapper;

    public ResponseEntity<UserResponseDto> post(UserRequestDto requestDto) {
        userRepo.save(userMapper.toUserEntity(requestDto));
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<UserResponseDto> update(UserRequestDto requestDto) {
        UserEntity userEntity = userMapper.toUserEntity(requestDto);
        userRepo.save(userEntity);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> delete(Long id) {
        userRepo.deleteById(id);
        if(userRepo.existsById(id)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<UserPagingDto> getAll(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<UserEntity> userEntities = userRepo.findAll(pageable);
        return ResponseEntity.ok(userMapper.toUserPagingDto(userEntities));
    }
}
