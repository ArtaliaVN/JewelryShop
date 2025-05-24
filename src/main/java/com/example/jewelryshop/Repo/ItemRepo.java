package com.example.jewelryshop.Repo;

import com.example.jewelryshop.Entity.ItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepo extends CrudRepository<ItemEntity, Long> {
}
