package com.example.jewelryshop.Service;

import com.example.jewelryshop.Dto.UserRequestDto;
import com.example.jewelryshop.Dto.UserResponseDto;
import com.example.jewelryshop.Entity.UserEntity;
import com.example.jewelryshop.Repo.UserRepo;
import com.example.jewelryshop.Utils.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    private final UserRepo userRepo;

    @Autowired
    private final UserMapper userMapper;

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

    public ResponseEntity<List<UserResponseDto>> getAll() {
        List<UserResponseDto> userResponseDtos = userMapper.toUserResponseDto((List<UserEntity>) userRepo.findAll());
        return ResponseEntity.ok().body(userResponseDtos);
    }
}
