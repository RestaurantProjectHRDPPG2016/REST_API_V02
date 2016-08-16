package org.khmeracademy.rest.pp.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.khmeracademy.rest.pp.entity.Restaurant;
import org.khmeracademy.rest.pp.entity.UploadRest;
import org.khmeracademy.rest.pp.utilities.Pagination;

public interface RestaurantService {
	boolean remove(int id);
	int save(Restaurant restaurant);
	boolean update(Restaurant retaurant);
	long CountfindAll();
	ArrayList<Restaurant> findAll(Pagination pagination);
	ArrayList<Restaurant> findByTypeId(int TypeId,Pagination pagination);
	ArrayList<Restaurant> findByCategoryId(int CategoryId,Pagination pagination);
	ArrayList<Restaurant> findByRestId(int id);
}
