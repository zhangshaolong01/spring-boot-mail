package com.itstyle.mail.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.itstyle.mail.entity.Tables;

public interface TableRepository extends JpaRepository<Tables, Integer>{
	
	@Query(value = "SELECT a FROM Tables a WHERE table_name like :tableName")
	Page<Tables> findByName(@Param("tableName")String name, Pageable pageable);//直接添加分页参数
	 
}
