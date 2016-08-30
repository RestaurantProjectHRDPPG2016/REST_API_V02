package org.khmeracademy.rest.pp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.khmeracademy.rest.pp.entity.MainCategory;
import org.khmeracademy.rest.pp.entity.RestaurantView;
import org.khmeracademy.rest.pp.service.RestaurantViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantViewController {
	@Autowired
	private RestaurantViewService restaurantViewService;
	
	@RequestMapping(value="/restauant/views/{id}" , method = RequestMethod.PUT)
	public ResponseEntity<Map<String , Object>> update(@PathVariable("id") int id){
		Map<String , Object> map = new HashMap<String , Object>();
		try{
			if(restaurantViewService.update(id)){
				map.put("MESSAGE", "View has been inserted.");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "View has not been inserted.");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("MESSAGE", "ERROR!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map , HttpStatus.OK);
	}
	
	@RequestMapping(value="/restauant/views/{id}" , method = RequestMethod.GET)
	public ResponseEntity<Map<String , Object>> findRestaurantViewByRestId(@PathVariable("id") int id){
		Map<String , Object> map = new HashMap<String , Object>();
		try{
			int restaurantViews = restaurantViewService.findViewByRestId(id);
			map.put("CODE", "200");
			map.put("MESSAGE", "RECORDS FOUND!");
			map.put("DATA", restaurantViews);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
}
