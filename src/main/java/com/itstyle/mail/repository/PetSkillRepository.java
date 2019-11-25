package com.itstyle.mail.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.itstyle.mail.entity.PetSkill;

/**
 * @author zhangshaolong
 *
 */	
public interface PetSkillRepository extends Repository<PetSkill, Integer>{

	@Query(nativeQuery = true, value = "SELECT a.id,a.level,a.pet_id,a.skill_id,b.skill_name,b.skill_type,b.hit_accuracy,b.cool_time,b.image,b.memo FROM pet_skill a,skill b WHERE a.skill_id = b.skill_id AND a.pet_id = ?1 ORDER BY a.level")
	List<PetSkill> getPetSkillList(String petId);
}
