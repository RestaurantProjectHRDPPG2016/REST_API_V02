	package org.khmeracademy.rest.pp.service.impl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.khmeracademy.rest.pp.entity.RestImgFile;
import org.khmeracademy.rest.pp.entity.Restaurant;
import org.khmeracademy.rest.pp.entity.UploadRest;
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
		
		System.out.println(restaurant.getId());
		
		
		//System.out.println(restaurant.getTel().get(0).getTel() + "");
		try{
			restaurantRepository.insertTelephone(restaurant.getTel(), restaurant.getId());
			restaurantRepository.insertMenu(restaurant.getMenus(), restaurant.getId());

			restaurantRepository.insertImage(restaurant.getImages(), restaurant.getId());
		}catch(Exception e){
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public boolean update(Restaurant restaurant) {
		restaurantRepository.updateMyObject_Annotation(restaurant);
		
		System.out.println(restaurant.getId());
		
		
		//System.out.println(restaurant.getTel().get(0).getTel() + "");
		try{
			restaurantRepository.updateTelephone(restaurant.getTel(), restaurant.getId());
			restaurantRepository.updateMenu(restaurant.getMenus(), restaurant.getId());

			restaurantRepository.updatetImage(restaurant.getImages(), restaurant.getId());
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
	@Override
	public ArrayList<Restaurant> findAll(Pagination pagination) {
		return restaurantRepository.findAll(pagination);
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
	public long CountfindAll() {
		return restaurantRepository.countFindAll();
	}

	@Override
	public long countFindByCatID(int id) {
		return restaurantRepository.countFindByCatID(id);
	}

	@Override
	public long countFindByTypeID(int id) {
		return restaurantRepository.countFindByTypeID(id) ;
	}



}
