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
public class Tables implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 自增主键
	 */
	private Integer id;

	/**
	 * 库名
	 */
	private String tableSchema;
	
	/**
	 * 表名
	 */
	private String tableName;

	/**
	 * 描述
	 */
	private String tableComment;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "table_schema", nullable = false)
	public String getTableSchema() {
		return tableSchema;
	}

	public void setTableSchema(String tableSchema) {
		this.tableSchema = tableSchema;
	}

	@Column(name = "table_name", nullable = false)
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@Column(name = "table_comment", nullable = false)
	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

}
