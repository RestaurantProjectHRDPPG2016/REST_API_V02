package org.khmeracademy.rest.pp.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.rest.pp.entity.RestaurantView;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantViewRepository {
	@Update ("UPDATE rest_rest_view"
			+ "SET v_r_number= v_r_number+1 "
			+ "WHERE rest_id=#{id}")
	boolean UpdateRestView(int id);
	
	@Select("select v_r_number "
			+ "from rest_rest_view V "
			+ "INNER JOIN rest_restaurant R ON V.rest_id = R.rest_id "
			+ "WHERE V.rest_id =#{id} ")
	ArrayList<RestaurantView> getRestaurantViewByrestId(int id);
}
