package org.khmeracademy.rest.pp.service;

import java.util.ArrayList;

import org.khmeracademy.rest.pp.entity.Restaurant;

public interface RestaurantService {
	boolean remove(int id);
	int save(Restaurant restaurant);
	boolean update(Restaurant retaurant);
	ArrayList<Restaurant> findAll();
}
