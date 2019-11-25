package com.itstyle.mail.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhangshaolong
 *
 */
@Entity
@Table(name = "skill")
public class Skill implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private Integer skillId;
	/**
	 * 技能名称
	 */
	private String skillName;
	/**
	 * 技能类型
	 */
	private String skillType;
	/**
	 * 命中
	 */
	private String hitAccuracy;
	/**
	 * 冷却
	 */
	private String coolTime;
	/**
	 * 图标
	 */
	private String image;
	/**
	 * 备注
	 */
	private String memo;

	@Id
	@Column(name = "skill_id", unique = true, nullable = false)
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
		return coolTime;
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
