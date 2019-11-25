package com.itstyle.mail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itstyle.mail.entity.Skill;

/**
 * @author zhangshaolong
 *
 */	
public interface SkillRepository extends JpaRepository<Skill, Integer>{
	
}
