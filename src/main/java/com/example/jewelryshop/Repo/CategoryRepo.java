package com.example.jewelryshop.Repo;

import com.example.jewelryshop.Entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<Category, Integer> {
}
