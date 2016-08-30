package org.khmeracademy.rest.pp.service.impl;

import java.util.ArrayList;

import org.khmeracademy.rest.pp.entity.RestaurantView;
import org.khmeracademy.rest.pp.repository.RestaurantViewRepository;
import org.khmeracademy.rest.pp.service.RestaurantViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RestaurantViewServiceImpl implements RestaurantViewService{
	@Autowired 
	private RestaurantViewRepository restaurantViewRepository;

	@Override
	public boolean update(int id) {
		return restaurantViewRepository.UpdateRestView(id);
	}
	@Override
	public int findViewByRestId(int id){
		return restaurantViewRepository.getRestaurantViewByrestId(id);
	}

}
