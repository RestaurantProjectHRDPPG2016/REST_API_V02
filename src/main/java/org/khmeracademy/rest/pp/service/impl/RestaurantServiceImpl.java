	package org.khmeracademy.rest.pp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.khmeracademy.rest.pp.entity.Restaurant;
import org.khmeracademy.rest.pp.filter.RestaurantFilter;
import org.khmeracademy.rest.pp.repository.RestaurantRepository;
import org.khmeracademy.rest.pp.service.RestaurantService;
import org.khmeracademy.rest.pp.utilities.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	@Autowired RestaurantRepository restaurantRepository;
	@Override
	public boolean remove(int id) {
		restaurantRepository.deleteMyObject_Annotation(id);
		try{
			 restaurantRepository.deleteMenu(id);
			 restaurantRepository.deleteImage(id);
			 restaurantRepository.deleteTelephone(id);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}

	@Override
	
	public int save(Restaurant restaurant) {
		restaurantRepository.insertMyObject_Annotation(restaurant);
		
		
		//System.out.println(restaurant.getTel().get(0).getTel() + "");
		try{
			restaurantRepository.insertTelephone(restaurant.getTelephone(), restaurant.getId());
			restaurantRepository.insertMenu(restaurant.getMenus(), restaurant.getId());
			restaurantRepository.insertImage(restaurant.getImages(), restaurant.getId());
		}catch(Exception e){
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public boolean update(Restaurant restaurant) {
		
		try{
			if (restaurantRepository.updateMyObject_Annotation(restaurant)){
				
				if (restaurant.getImages() != null && !restaurant.getImages().isEmpty()){
					restaurantRepository.insertImage(restaurant.getImages(), restaurant.getId());
				}
				
				if (restaurant.getMenus() != null && !restaurant.getMenus().isEmpty()){
					restaurantRepository.insertMenu(restaurant.getMenus(), restaurant.getId());
				}
				
				if (restaurant.getTelephone() != null && !restaurant.getTelephone().isEmpty()){
					restaurantRepository.updateTelephone(restaurant.getTelephone(), restaurant.getId());
				}
				
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return false;
	}
	@Override
	public ArrayList<Restaurant> findAll(String get​province,RestaurantFilter filter, Pagination pagination) {
//		return restaurantRepository.findAll(get​province,filter, pagination);
		return restaurantRepository.findAll(filter, pagination);
	}
	


	@Override
	public ArrayList<Restaurant> findByCategoryId(int id,Pagination pagination) {
		return restaurantRepository.findByCategoryId(id,pagination);
	}

	@Override
	public ArrayList<Restaurant> findByRestId(int id) {
		return restaurantRepository.findByRestId(id);
	}

	@Override
	public ArrayList<Restaurant> findByTypeId(int TypeId,Pagination pagination) {
		return restaurantRepository.findByTypeId(TypeId, pagination);
	}

	@Override
	public long CountfindAll(RestaurantFilter filter) {
		return restaurantRepository.countFindAll(filter);
	}

	@Override
	public long countFindByCatID(int id) {
		return restaurantRepository.countFindByCatID(id);
	}

	@Override
	public long countFindByTypeID(int id) {
		return restaurantRepository.countFindByTypeID(id) ;
	}

	@Override
	public boolean deleteRestaurantImage(List<Integer> deletedImageIDs) {
		return restaurantRepository.deleteRestaurantImage(deletedImageIDs);
	}

	@Override
	public boolean deleteMenuImage(List<Integer> deletedMenuIDs) {
		return restaurantRepository.deleteMenuImage(deletedMenuIDs);
	}


	@Override
	public ArrayList<Restaurant> findByAddToFavorite(int id, Pagination pagination) {
		return restaurantRepository.findByAddToFavorite(id, pagination);
	}

	@Override
	public long countFindByAddToFavorite(int id) {
		return restaurantRepository.countFindAddToFavorite(id);
	}



}
