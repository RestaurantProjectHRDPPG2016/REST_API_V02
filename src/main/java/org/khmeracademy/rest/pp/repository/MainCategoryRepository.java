package org.khmeracademy.rest.pp.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.rest.pp.entity.MainCategory;
import org.springframework.stereotype.Repository;

@Repository
public interface MainCategoryRepository {
	@Delete("DELETE FROM rest_categories WHERE c_id=#{id}")
	boolean remove(int id);
	@Update("UPDATE rest_categories SET c_name=#{name}, c_img1=#{img1},c_img2=#{img2} WHERE c_id=#{id}")
	boolean update(MainCategory mainCategory);
	@Insert("INSERT INTO rest_categories (c_name,c_img1,c_img2) VALUES (#{name},#{img1},#{img2})")
	boolean save(MainCategory mainCategory);
	@Select("SELECT c_id,c_name,c_img1,c_img2 FROM rest_categories ORDER BY c_id DESC")
	@Results({
		@Result(property="id",column="c_id"),
		@Result(property="name",column="c_name"),
		@Result(property="img1",column="c_img1"),
		@Result(property="img2",column="c_img2")
	})
	ArrayList<MainCategory> findAll();
}
