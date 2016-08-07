package org.khmeracademy.rest.pp.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.rest.pp.entity.RestType;
import org.springframework.stereotype.Repository;

@Repository
public interface RestTypeRepository {
	
	@Delete("DELETE FROM rest_rest_type WHERE rest_type_id=#{id}")
	boolean remove(int id);
	@Update("UPDATE rest_rest_type SET name=#{name} WHERE rest_type_id=#{id}")
	boolean update(RestType restType);
	@Insert("INSERT INTO rest_rest_type (name) VALUES (#{name})")
	boolean save(RestType restType);
	@Select("SELECT rest_type_id, name FROM rest_rest_type ORDER BY rest_type_id DESC")
	@Results({
		@Result(property="id",column="rest_type_id"),
		@Result(property="name",column="name"),
	})
	ArrayList<RestType> findAll();
}
