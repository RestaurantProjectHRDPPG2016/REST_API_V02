package org.khmeracademy.rest.pp.service;

import java.util.ArrayList;
import java.util.List;

import org.khmeracademy.rest.pp.entity.Restaurant;
import org.khmeracademy.rest.pp.filter.RestaurantFilter;
import org.khmeracademy.rest.pp.utilities.Pagination;

public interface RestaurantService {
	boolean remove(int id);
	int save(Restaurant restaurant);
	boolean update(Restaurant retaurant);
	long CountfindAll(RestaurantFilter filter);
	long countFindByCatID(int id);
	long countFindByTypeID(int id);
	long countFindByAddToFavorite(int id);
	ArrayList<Restaurant> findAll(String get​province,RestaurantFilter filter, Pagination pagination);
	ArrayList<Restaurant> findByTypeId(int TypeId,Pagination pagination);
	ArrayList<Restaurant> findByCategoryId(int CategoryId,Pagination pagination);
	ArrayList<Restaurant> findByRestId(int id);
	ArrayList<Restaurant> findByAddToFavorite(int id,Pagination pagination);
	boolean deleteRestaurantImage(List<Integer> deletedImageIDs);
	public boolean deleteMenuImage(List<Integer> deletedMenuIDs);
}
