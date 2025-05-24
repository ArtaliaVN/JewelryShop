package com.example.jewelryshop.Repo;

import com.example.jewelryshop.Entity.CartEntity;
import org.springframework.data.repository.CrudRepository;

public interface CartRepo extends CrudRepository<CartEntity, Long> {
}
