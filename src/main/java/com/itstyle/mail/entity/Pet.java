package com.itstyle.mail.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhangshaolong
 *
 */
@Entity
@Table(name = "pet")
public class Pet implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private Integer Id;
	/**
	 * 类型
	 */
	private String petType;
	/**
	 * 名称
	 */
	private String petNameCn;
	/**
	 * 装笼
	 */
	private String isCage;
	/**
	 * 来源
	 */
	private String sourceType;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return Id;
	}

	/**
	 * TODO
	 * @param id
	 * @return void
	 * @author:  zhangshaolong
	 * @methodsName: setId
	 * @time: 2019年10月21日 下午3:31:06
	 */
	public void setId(Integer id) {
		Id = id;
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

	/**  
	 * TODO
	 * @return: String isCage
	 */
	public String getIsCage() {
		return isCage;
	}

	/**
	 * TODO
	 * @param isCage
	 */
	public void setIsCage(String isCage) {
		this.isCage = isCage;
	}

	/**  
	 * TODO
	 * @return: String sourceType
	 */
	public String getSourceType() {
		return sourceType;
	}

	/**
	 * TODO
	 * @param String sourceType
	 */
	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	


}
