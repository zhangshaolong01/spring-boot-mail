package com.itstyle.mail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itstyle.mail.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
