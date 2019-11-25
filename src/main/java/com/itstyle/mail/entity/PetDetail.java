package com.itstyle.mail.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description pet对象
 * @author zhangshaolong
 * @version 1.0.0
 * @createtime 2019-10-09
 */
@Entity
@Table(name = "pet")
public class PetDetail {

	private Integer id;// id
	private String itemId;// 物品id
	private String petId;// 宠物id
	private String petType;// 类型
	private String petNameCn;// 中文名
	private String petNameTd;// 繁体名
	private String petNameEn;// 英文名
	private String isCage;// 装笼
	private String sourceType;// 来源类型
	private String sourceTypeDetail;// 专业类型
	private String acquisitionMethod;// 获取来源
	private String itemNameCn;// 物品名
	private String itemNameTd;// 物品繁体名
	private String itemNameEn;// 物品英文名
	private String camp;// 阵营
	private String isOnly;// 是否唯一
	private String price;// 售价
	private String priceUnit;// 价格单位
	private String addedVersion;// 加入版本
	private String image;// 图片
	private String described;// 图片
	private String memo;// 备注

	/**
	 * 主键
	 * @return: String name
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// 物品id
	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	// 宠物id
	public String getPetId() {
		return petId;
	}

	public void setPetId(String petId) {
		this.petId = petId;
	}

	// 类型
	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}

	// 中文名
	public String getPetNameCn() {
		return petNameCn;
	}

	public void setPetNameCn(String petNameCn) {
		this.petNameCn = petNameCn;
	}

	// 繁体名
	public String getPetNameTd() {
		return petNameTd;
	}

	public void setPetNameTd(String petNameTd) {
		this.petNameTd = petNameTd;
	}

	// 英文名
	public String getPetNameEn() {
		return petNameEn;
	}

	public void setPetNameEn(String petNameEn) {
		this.petNameEn = petNameEn;
	}

	// 装笼
	public String getIsCage() {
		return isCage;
	}

	public void setIsCage(String isCage) {
		this.isCage = isCage;
	}

	// 来源类型
	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	// 专业类型
	public String getSourceTypeDetail() {
		return sourceTypeDetail;
	}

	public void setSourceTypeDetail(String sourceTypeDetail) {
		this.sourceTypeDetail = sourceTypeDetail;
	}

	public String getDescribed() {
		return described;
	}

	public void setDescribed(String described) {
		this.described = described;
	}

	// 获取来源
	public String getAcquisitionMethod() {
		return acquisitionMethod;
	}

	public void setAcquisitionMethod(String acquisitionMethod) {
		this.acquisitionMethod = acquisitionMethod;
	}

	// 物品名
	public String getItemNameCn() {
		return itemNameCn;
	}

	public void setItemNameCn(String itemNameCn) {
		this.itemNameCn = itemNameCn;
	}

	// 物品繁体名
	public String getItemNameTd() {
		return itemNameTd;
	}

	public void setItemNameTd(String itemNameTd) {
		this.itemNameTd = itemNameTd;
	}

	// 物品英文名
	public String getItemNameEn() {
		return itemNameEn;
	}

	public void setItemNameEn(String itemNameEn) {
		this.itemNameEn = itemNameEn;
	}

	// 阵营
	public String getCamp() {
		return camp;
	}

	public void setCamp(String camp) {
		this.camp = camp;
	}

	// 是否唯一
	public String getIsOnly() {
		return isOnly;
	}

	public void setIsOnly(String isOnly) {
		this.isOnly = isOnly;
	}

	// 售价
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	// 价格单位
	public String getPriceUnit() {
		return priceUnit;
	}

	public void setPriceUnit(String priceUnit) {
		this.priceUnit = priceUnit;
	}

	// 加入版本
	public String getAddedVersion() {
		return addedVersion;
	}

	public void setAddedVersion(String addedVersion) {
		this.addedVersion = addedVersion;
	}

	// 图片
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	// 备注
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
}