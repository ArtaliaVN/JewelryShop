package com.example.jewelryshop.Service;

import com.example.jewelryshop.Dto.ItemRequestDto;
import com.example.jewelryshop.Entity.Category;
import com.example.jewelryshop.Entity.ItemEntity;
import com.example.jewelryshop.Dto.ItemPagingDto;
import com.example.jewelryshop.Repo.ItemRepo;
import com.example.jewelryshop.Utils.ItemMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemService {
    @Autowired
    private final ItemRepo itemRepo;

    @Autowired
    private final ItemMapper itemMapper;

    public void post(ItemRequestDto requestDto) {
        itemRepo.save(itemMapper.toItemEntity(requestDto));
    }

    public Boolean delete(Long id) {
        itemRepo.deleteById(id);
        return itemRepo.existsById(id);
    }

    public Boolean existsById(long id) {
        return itemRepo.existsById(id);
    }

    public Boolean existByName(String name) {
        return itemRepo.existsByName(name);
    }

    public ItemPagingDto getAll(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<ItemEntity> itemEntities = itemRepo.findAll(pageable);
        return itemMapper.toItemPagingDto(itemEntities);
    }

    public ItemPagingDto getByCategory(Integer pageNumber, Integer pageSize, Category category) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<ItemEntity> itemEntities = itemRepo.findByCategory(pageable, category);
        return itemMapper.toItemPagingDto(itemEntities);
    }
}
