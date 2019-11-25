package com.itstyle.mail.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @version: V1.0
 * @author: fendo
 * @className: user
 * @packageName: user
 * @description: 这是用户类
 * @data: 2017-07-28 12:20
 **/

/**

* 类的描述

* @author Administrator

* @Time 2012-11-2014:49:01

*

*/

@Entity
@Table(name = "pet_type")
public class PetType implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private Integer typeId;
	/**
	 * 类型名称
	 */
	private String typeName;
	/**
	 * 图片
	 */
	private String typeImage;
	/**
	 * 特效
	 */
	private String speciallyEffect;

	@Id
	@Column(name = "type_id", unique = true, nullable = false)
	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeImage() {
		return typeImage;
	}

	public void setTypeImage(String typeImage) {
		this.typeImage = typeImage;
	}

	public String getSpeciallyEffect() {
		return speciallyEffect;
	}

	public void setSpeciallyEffect(String speciallyEffect) {
		this.speciallyEffect = speciallyEffect;
	}

}
