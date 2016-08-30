package org.khmeracademy.rest.pp.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.rest.pp.entity.RestaurantView;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantViewRepository {
	@Update ("UPDATE rest_restaurant SET views= views+1 "
			+ " WHERE rest_id=#{id} ")
	boolean UpdateRestView(int id);
	
	@Select("select views from rest_restaurant where rest_id=#{id}")
	int getRestaurantViewByrestId(int id);
}
