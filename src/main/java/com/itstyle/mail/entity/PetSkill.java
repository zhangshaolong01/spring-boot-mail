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
@SecondaryTable(name = "skill")
public class PetSkill implements Serializable {

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

	// ------------skill-------------------
	/**
	 * 技能名称
	 */
	@Column(name = "skill_name")
	private String skillName;
	/**
	 * 技能类型
	 */
	@Column(name = "skill_type")
	private String skillType;
	/**
	 * 命中
	 */
	@Column(name = "hit_accuracy")
	private String hitAccuracy;
	/**
	 * 冷却
	 */
	@Column(name = "cool_time")
	private String coolTime;
	/**
	 * 图标
	 */
	@Column(name = "image")
	private String image;
	/**
	 * 备注
	 */
	@Column(name = "memo")
	private String memo;

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

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getSkillId() {
		return skillId;
	}

	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getSkillType() {
		return skillType;
	}

	public void setSkillType(String skillType) {
		this.skillType = skillType;
	}

	public String getHitAccuracy() {
		return hitAccuracy;
	}

	public void setHitAccuracy(String hitAccuracy) {
		this.hitAccuracy = hitAccuracy;
	}

	public String getCoolTime() {
		return coolTime == null ? "" : coolTime;
	}

	public void setCoolTime(String coolTime) {
		this.coolTime = coolTime;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
