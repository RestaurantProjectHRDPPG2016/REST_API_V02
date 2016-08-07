package org.khmeracademy.rest.pp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.khmeracademy.rest.pp.entity.MainCategory;
import org.khmeracademy.rest.pp.entity.Restaurant;
import org.khmeracademy.rest.pp.service.MainCategoryService;
import org.khmeracademy.rest.pp.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.undertow.attribute.RequestMethodAttribute;

@RestController
public class AdminController {
	@Autowired
	private MainCategoryService mainCategoryService;
	@Autowired
	private RestaurantService restaurantService;
	
	@RequestMapping(value="/maincategory", method= RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> findAll(){
		ArrayList<MainCategory> mainCategory = mainCategoryService.findAll();

		Map<String, Object> map = new HashMap<>();
		map.put("CODE","200");
		map.put("MESSAGE","RECORDS FOUND!");
		map.put("DATA", mainCategory);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	@RequestMapping(value="/maincategory" , method = RequestMethod.POST)
	public ResponseEntity<Map<String , Object>> save(@RequestBody MainCategory mainCategory){
		Map<String , Object> map = new HashMap<String , Object>();
		try{
			if(mainCategoryService.save(mainCategory)){
				map.put("MESSAGE", "User has been inserted.");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "User has not been inserted.");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("MESSAGE", "ERROR!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map , HttpStatus.OK);
	}
	
//	@RequestMapping(value="/delete-user/{user-id}/{role-id}" , method = RequestMethod.DELETE )
	@RequestMapping(value="/maincategory/{id}" , method = RequestMethod.DELETE )
	public ResponseEntity<Map<String, Object>> remove(@PathVariable("id") int id){
		Map<String , Object> map = new HashMap<String , Object>();
		boolean status = mainCategoryService.remove(id);
		try{
			if(status ){
				map.put("MESSAGE", "User has been deleted");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "User has not been deleted");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			e.printStackTrace();
			map.put("STATUS", false);
		}
		return new ResponseEntity<Map<String,Object>>(map , HttpStatus.OK);
	}
	

	@RequestMapping(value="maincategory",method=RequestMethod.PUT)
	public ResponseEntity<Map<String, Object>> update(@RequestBody MainCategory mainCategory){
		Map<String, Object> map = new HashMap<String , Object>();
		try{
			if(mainCategoryService.update(mainCategory)){
				map.put("MESSAGE", "User has been updated");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "User has not been updated");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("MESSAGE", "Error!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map , HttpStatus.OK);
	}
	
	@RequestMapping(value="/restaurant" , method = RequestMethod.POST)
	public ResponseEntity<Map<String , Object>> saveRestaurant(@RequestBody Restaurant restaurant){
		Map<String , Object> map = new HashMap<String , Object>();
		
		try{
			if(restaurantService.save(restaurant)>0){
				map.put("MESSAGE", "User has been inserted.");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "User has not been inserted.");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("MESSAGE", "ERROR!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		System.out.println(this);
		return new ResponseEntity<Map<String,Object>>(map , HttpStatus.OK);
		
	}
}
