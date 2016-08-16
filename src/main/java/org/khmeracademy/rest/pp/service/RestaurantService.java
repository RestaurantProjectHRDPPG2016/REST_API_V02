package org.khmeracademy.rest.pp.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.khmeracademy.rest.pp.entity.Restaurant;
import org.khmeracademy.rest.pp.entity.UploadRest;

public interface RestaurantService {
	boolean remove(int id);
	int save(Restaurant restaurant);
	boolean update(Restaurant retaurant);
	ArrayList<Restaurant> findAll();
	ArrayList<Restaurant> findByTypeId(int TypeId);
	ArrayList<Restaurant> findByCategoryId(int CategoryId);
	ArrayList<Restaurant> findByRestId(int id);
}
