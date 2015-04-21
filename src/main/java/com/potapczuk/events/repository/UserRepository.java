package com.potapczuk.events.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.potapczuk.events.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
