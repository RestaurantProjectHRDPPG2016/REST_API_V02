package org.khmeracademy.rest.pp.service.impl;

import java.util.ArrayList;

import org.khmeracademy.rest.pp.entity.Restaurant;
import org.khmeracademy.rest.pp.repository.RestaurantRepository;
import org.khmeracademy.rest.pp.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RestaurantServiceImpl implements RestaurantService {
	@Autowired RestaurantRepository restaurantRepository;
	@Override
	public boolean remove(int id) {
		return restaurantRepository.remove(id);
	}

	@Override
	
	public int save(Restaurant restaurant) {
		restaurantRepository.insertMyObject_Annotation(restaurant);
		
		restaurantRepository.insertBatch(restaurant.getMenus(), restaurant.getId());

		restaurantRepository.insertBatch1(restaurant.getImages(), restaurant.getId());
		restaurantRepository.insertBatch2(restaurant.getTel(),restaurant.getId());
		return 1;
	}

	@Override
	public boolean update(Restaurant retaurant) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Restaurant> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
