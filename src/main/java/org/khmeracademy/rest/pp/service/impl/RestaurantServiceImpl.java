package org.khmeracademy.rest.pp.service.impl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.khmeracademy.rest.pp.entity.RestImgFile;
import org.khmeracademy.rest.pp.entity.Restaurant;
import org.khmeracademy.rest.pp.entity.UploadRest;
import org.khmeracademy.rest.pp.repository.RestaurantRepository;
import org.khmeracademy.rest.pp.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	@Autowired 
	RestaurantRepository restaurantRepository;
	
	@Autowired 
	RestImgFileServiceImpl restImgFileServiceimpl;
	
	@Override
	public boolean remove(int id) {
		restaurantRepository.deleteMyObject_Annotation(id);
		try{
			 restaurantRepository.deleteBatch(id);
			 restaurantRepository.deleteBatch1(id);
			 restaurantRepository.deleteBatch2(id);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public int save(UploadRest uploadRest, HttpServletRequest request) {
		
		Restaurant res = new Restaurant();
			res.setName(uploadRest.getName());
			res.setType(uploadRest.getType());
			res.setDelivery(uploadRest.getDelivery());
			res.setDesc(uploadRest.getDescription());
			res.setHome(uploadRest.getHomenumber());
			res.setStreet(uploadRest.getStreet());
			res.setCommune(uploadRest.getCommune());
			res.setDistrict(uploadRest.getDistrict());
			res.setTel(uploadRest.getTelephone());
		
		//upload menu
		RestImgFile menuUpload= restImgFileServiceimpl.upload(uploadRest.getMenus(), null, request);		
		
		//uplod image
		RestImgFile imageUpload = restImgFileServiceimpl.upload(uploadRest.getImage(), null, request);
		
		
		restaurantRepository.insertMyObject_Annotation(res);
		
		System.out.println(res.getId());
		
		
		//System.out.println(restaurant.getTel().get(0).getTel() + "");
		try{
			restaurantRepository.insertTelephone(res.getTel(), res.getId());
			restaurantRepository.insertMenu(menuUpload.getNames(), res.getId());
			restaurantRepository.insertImage(imageUpload.getNames(), res.getId());
		}catch(Exception e){
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public boolean update(Restaurant restaurant) {
//		restaurantRepository.updateMyObject_Annotation(restaurant);
//		
//		System.out.println(restaurant.getId());
//		
//		
//		//System.out.println(restaurant.getTel().get(0).getTel() + "");
//		try{
//			restaurantRepository.updateBatch2(restaurant.getTel(), restaurant.getId());
//			restaurantRepository.updateBatch(restaurant.getMenus(), restaurant.getId());
//			restaurantRepository.updatetBatch1(restaurant.getImages(), restaurant.getId());
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		return true;
	}

	@Override
	public ArrayList<Restaurant> findAll() {
		return restaurantRepository.findAll();
	}
	

}
