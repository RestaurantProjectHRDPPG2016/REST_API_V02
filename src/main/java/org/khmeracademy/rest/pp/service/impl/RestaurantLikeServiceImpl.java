package org.khmeracademy.rest.pp.service.impl;

import org.khmeracademy.rest.pp.repository.RestaurantLikeRepository;
import org.khmeracademy.rest.pp.service.RestaurantLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RestaurantLikeServiceImpl implements RestaurantLikeService{
	@Autowired
	private RestaurantLikeRepository restaurantLikeRepository;
	@Override
	public boolean update(int id) {
		return restaurantLikeRepository.UpdateRestLike(id);
	}

}
