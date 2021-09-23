package com.fazial.filedemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fazial.filedemo.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
