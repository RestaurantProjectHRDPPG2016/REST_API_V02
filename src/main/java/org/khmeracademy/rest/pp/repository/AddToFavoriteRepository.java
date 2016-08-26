package org.khmeracademy.rest.pp.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.khmeracademy.rest.pp.entity.AddToFavorite;
import org.springframework.stereotype.Repository;
@Repository
public interface AddToFavoriteRepository {
	@Delete("DELETE FROM rest_save WHERE rest_id=#{id}")
	boolean remove(int id);
	@Insert("INSERT INTO rest_save (m_id,rest_id) VALUES (#{m_id},#{r_id})")
	 boolean save(AddToFavorite addToFavorite);
}
