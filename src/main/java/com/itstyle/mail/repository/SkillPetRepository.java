package com.itstyle.mail.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.itstyle.mail.entity.SkillPet;

/**
 * @author zhangshaolong
 *
 */	
public interface SkillPetRepository extends Repository<SkillPet, Integer>{

	@Query(nativeQuery = true, value = "SELECT a.id,a.level,a.skill_id,a.pet_id,b.pet_name_cn,b.pet_type FROM pet_skill a,pet b WHERE a.pet_id = b.id AND a.skill_id = ?1 ORDER BY a.level")
	List<SkillPet> getSkillPetList(String skillId);
}
