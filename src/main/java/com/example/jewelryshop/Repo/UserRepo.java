package com.example.jewelryshop.Repo;

import com.example.jewelryshop.Entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    public Page<UserEntity> findAll(Pageable pageable);

    public UserEntity findByUsername(String name);

    public Boolean existsByUsername(String name);
}
