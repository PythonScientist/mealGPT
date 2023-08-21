package com.alimama.mealgpt.dao;

import com.alimama.mealgpt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUserName(String userName);
}
