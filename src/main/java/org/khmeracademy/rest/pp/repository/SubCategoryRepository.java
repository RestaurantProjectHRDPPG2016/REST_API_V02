package org.khmeracademy.rest.pp.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.rest.pp.entity.SubCategory;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository {
	@Delete("DELETE FROM rest_sub_categories WHERE sub_cat_id=#{id}")
	boolean remove(int id);
	@Update("UPDATE rest_sub_categories SET c_id=#{s_id}, name=#{name}, img=#{img} WHERE sub_cat_id=#{id}")
	boolean update(SubCategory subCategory);
	@Insert("INSERT INTO rest_sub_categories (c_id,name,img) VALUES (#{s_id},#{name},#{img})")
	boolean save(SubCategory msubCategory);
	@Select("SELECT * FROM rest_sub_categories ORDER BY sub_cat_id DESC")
	@Results({
		@Result(property="id",column="sub_cat_id"),
		@Result(property="s_id",column="c_id"),
		@Result(property="name",column="name"),
		@Result(property="img",column="img")
	})
	ArrayList<SubCategory> findAll();
}
