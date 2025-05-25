package com.example.jewelryshop.Repo;

import com.example.jewelryshop.Entity.Category;
import com.example.jewelryshop.Entity.ItemEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepo extends CrudRepository<ItemEntity, Long> {
    public Page<ItemEntity> findAll(Pageable pageable);

    public Page<ItemEntity> findByCategory(Pageable pageable, Category category);

    public ItemEntity findByName(String name);

    public Boolean existsByName(String name);

}
