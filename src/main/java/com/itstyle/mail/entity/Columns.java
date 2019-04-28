package com.itstyle.mail.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author zhangshaolong
 *
 */
@Entity
public class Columns implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 自增主键
	 */
	private Long id;

	/**
	 * 表名
	 */
	private String tableName;

	/**
	 * 列名
	 */
	private String columnName;

	/**
	 * 类型
	 */
	private String columnType;

	/**
	 * 长度
	 */
	private String length;
	
	/**
	 * 列描述
	 */
	private String columnComment;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "table_name", nullable = false)
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@Column(name = "column_name", nullable = false, length = 100)
	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	@Column(name = "column_type", nullable = false, length = 100)
	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	@Column(name = "length")
	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	@Column(name = "column_comment")
	public String getColumnComment() {
		return columnComment;
	}

	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}

}
