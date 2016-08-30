package org.khmeracademy.rest.pp.controller;

import java.util.HashMap;
import java.util.Map;

import org.khmeracademy.rest.pp.service.RestaurantLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class RestaurantLikeController {
	@Autowired
	private RestaurantLikeService restaurantLikeService;
	@RequestMapping(value="/restauant/likes/{id}" , method = RequestMethod.PUT)
	public ResponseEntity<Map<String , Object>> update(@PathVariable("id") int id){
		Map<String , Object> map = new HashMap<String , Object>();
		try{
			if(restaurantLikeService.update(id)){
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
}
