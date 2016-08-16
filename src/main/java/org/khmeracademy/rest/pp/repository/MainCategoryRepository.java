package org.khmeracademy.rest.pp.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.rest.pp.entity.MainCategory;
import org.khmeracademy.rest.pp.utilities.Pagination;
import org.springframework.stereotype.Repository;

@Repository
public interface MainCategoryRepository {
	@Delete("DELETE FROM rest_categories WHERE c_id=#{id}")
	boolean remove(int id);
	@Update("UPDATE rest_categories SET rest_type_id=#{t_id}, c_name=#{name}, img1=#{img1},img2=#{img2} WHERE c_id=#{id}")
	boolean update(MainCategory mainCategory);
	@Insert("INSERT INTO rest_categories (rest_type_id,c_name,img1,img2) VALUES (#{t_id},#{name},#{img1},#{img2})")
	boolean save(MainCategory mainCategory);
	@Select("SELECT * FROM rest_categories ORDER BY c_id DESC"

				+ "	LIMIT "
				+ "		#{limit} "
				
				+ "	OFFSET "
				+ "		#{offset}")
	@Results({
		@Result(property="id",column="c_id"),
		@Result(property="t_id",column="rest_type_id"),
		@Result(property="name",column="c_name"),
		@Result(property="img1",column="img1"),
		@Result(property="img2",column="img2")
	})
	ArrayList<MainCategory> findAll(Pagination pagination);
	
	@Select("SELECT COUNT (*) from rest_categories")
	public long totalCount();
}
