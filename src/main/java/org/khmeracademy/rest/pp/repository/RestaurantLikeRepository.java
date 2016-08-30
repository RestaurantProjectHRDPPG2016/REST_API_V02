package org.khmeracademy.rest.pp.repository;

import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
@Repository
public interface RestaurantLikeRepository {
	@Update ("UPDATE rest_restaurant SET likes= likes+1 "
			+ " WHERE rest_id=#{id} ")
	boolean UpdateRestLike(int id);
}
