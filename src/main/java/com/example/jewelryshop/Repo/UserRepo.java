package com.example.jewelryshop.Repo;

import com.example.jewelryshop.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
}
