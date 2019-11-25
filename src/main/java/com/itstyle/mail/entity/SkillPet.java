package com.itstyle.mail.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

/**
 * @author zhangshaolong
 *
 */
@Entity
@Table(name = "pet_skill")
@SecondaryTable(name = "pet")
public class SkillPet implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 宠物id
	 */
	@Id
	@Column(name = "id")
	private Integer id;
	/**
	 * 宠物id
	 */
	@Column(name = "pet_id")
	private Integer petId;
	/**
	 * 宠物id
	 */
	@Column(name = "skill_id")
	private Integer skillId;
	/**
	 * 级别
	 */
	@Column(name = "level")
	private Integer level;

	// ------------pet-------------------
	/**
	 * 级别
	 */
	@Column(name = "pet_name_cn")
	private String petNameCn;

	/**
	 * 级别
	 */
	@Column(name = "pet_type")
	private String petType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPetId() {
		return petId;
	}

	public void setPetId(Integer petId) {
		this.petId = petId;
	}

	public Integer getSkillId() {
		return skillId;
	}

	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getPetNameCn() {
		return petNameCn;
	}

	public void setPetNameCn(String petNameCn) {
		this.petNameCn = petNameCn;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}

}
