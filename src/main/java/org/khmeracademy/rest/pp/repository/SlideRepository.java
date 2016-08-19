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

	@Select("SELECT * FROM rest_slide")
	@Results({
		@Result(property="id", column="s_id"),
		@Result(property="name", column="name"),
		@Result(property="description", column="description"),
		@Result(property="status", column="status"),
		@Result(property="url", column="url")
	})
	ArrayList<Slide> findAll();
	
	@Insert("INSERT INTO rest_slide "
			+ "(id, name, description, status, url)"
			+ "VALUES"
			+ "(#{s_id}, #{name}, #{desciption}, #{status}, #{url})")
	boolean save(Slide slide);
	
	@Delete("DELETE FROM rest_slide WHERE s_id=#{id}")
	boolean remove(int id);
	
	@Update("UPDATE rest_slide SET"
			+ "s_id=#{id}, name=#{name}, description=#{description}, "
			+ "status=#{status}, url=#{url} ")
	boolean update(Slide slide);
}
