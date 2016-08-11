package org.khmeracademy.rest.pp.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.khmeracademy.rest.pp.entity.Restaurant;
import org.khmeracademy.rest.pp.entity.UploadRest;

public interface RestaurantService {
	boolean remove(int id);
	int save(UploadRest uploadRest, HttpServletRequest request);
	boolean update(Restaurant retaurant);
	ArrayList<Restaurant> findAll();
}
