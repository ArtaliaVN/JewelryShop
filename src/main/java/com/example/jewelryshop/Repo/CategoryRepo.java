package com.example.jewelryshop.Repo;

import com.example.jewelryshop.Entity.Category;
import com.example.jewelryshop.Entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<CategoryEntity, Integer> {
    CategoryEntity findByCategoryName(Category categoryName);
}
