package com.itstyle.mail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itstyle.mail.entity.Pet;

/**
 * @author zhangshaolong
 *
 */	
public interface PetRepository extends JpaRepository<Pet, Integer>{

}
