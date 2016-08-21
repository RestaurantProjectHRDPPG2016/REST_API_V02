package org.khmeracademy.rest.pp.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.rest.pp.entity.Slide;
import org.springframework.stereotype.Repository;

@Repository
public interface SlideRepository {

	@Select("SELECT * FROM rest_slide "
			+ "WHERE status = '1' ")
	@Results({
		@Result(property="s_id", column="s_id"),
		@Result(property="name", column="name"),
		@Result(property="description", column="description"),
		@Result(property="url", column="url")
	})
	ArrayList<Slide> findAll();
	
	@Insert("INSERT INTO rest_slide "
			+ "( name, description, status, url)"
			+ "VALUES"
			+ "( #{name}, #{description}, #{status}, #{url})")
	boolean save(Slide slide);
	
	@Delete("DELETE FROM rest_slide WHERE s_id=#{s_id}")
	boolean remove(int id);
	
	@Update("UPDATE rest_slide SET "
			+ " name=#{name}, description=#{description}, "
			+ "status=#{status}, url=#{url} WHERE s_id=#{s_id} ")
	boolean update(Slide slide);
}
