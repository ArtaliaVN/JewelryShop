package com.example.jewelryshop.Service;

import com.example.jewelryshop.Dto.ItemRequestDto;
import com.example.jewelryshop.Repo.ItemRepo;
import com.example.jewelryshop.Utils.ItemMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemService {
    @Autowired
    private final ItemRepo itemRepo;

    @Autowired
    private final ItemMapper itemMapper;

    public ResponseEntity<?> post(ItemRequestDto requestDto) {
        itemRepo.save(itemMapper.toItemEntity(requestDto));
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> delete(Long id) {
        itemRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
