package org.khmeracademy.rest.pp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.khmeracademy.rest.pp.entity.Restaurant;
import org.khmeracademy.rest.pp.entity.UploadRest;
import org.khmeracademy.rest.pp.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import springfox.documentation.annotations.ApiIgnore;

@RestController
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantService;
	
	@RequestMapping(value="/restaurant" , method = RequestMethod.POST)
	@ApiImplicitParams({
		    @ApiImplicitParam(name = "name", value = "Restaurant's name", required = true, dataType = "string", paramType = "query"),
		    @ApiImplicitParam(name = "description", value = "Restaurant's description", required = false, dataType = "string", paramType = "query"),
		    @ApiImplicitParam(name = "menuImage", value = "Restaurant's Menu Image", required = false, dataType = "file", paramType = "body"),
		    @ApiImplicitParam(name = "telephones", value = "Restaurant's Telephone", required = false, dataType = "array", paramType = "query"),
	})
	
	public ResponseEntity<Map<String , Object>> saveRestaurant(@ApiIgnore UploadRest uploadRest, @ApiIgnore HttpServletRequest request){
		Map<String , Object> map = new HashMap<String , Object>();
		
		try{
			int id = restaurantService.save(uploadRest,request);
			
				map.put("MESSAGE", "User has been inserted.");
				map.put("STATUS", true);
				map.put("ID", id);
			
		}catch(Exception e){
			map.put("MESSAGE", "ERROR!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		System.out.println(this);
		return new ResponseEntity<Map<String,Object>>(map , HttpStatus.OK);
	}
	
	@RequestMapping(value="/restaurant/{id}" , method = RequestMethod.DELETE )
		public ResponseEntity<Map<String,Object>> delelteCategory(@PathVariable("id") int id){
		Map<String , Object> map = new HashMap<String , Object>();
		boolean status = restaurantService.remove(id);
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
	
	
	@RequestMapping(value="/restaurant" , method = RequestMethod.PUT)
	public ResponseEntity<Map<String , Object>> updateRestaurant(@RequestBody Restaurant restaurant){
		Map<String , Object> map = new HashMap<String , Object>();
		
		try{
			boolean status = restaurantService.update(restaurant);
			if(status){
				map.put("MESSAGE", "User has been inserted.");
				map.put("STATUS", true);
			}
			
		}catch(Exception e){
			map.put("MESSAGE", "ERROR!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		System.out.println(this);
		return new ResponseEntity<Map<String,Object>>(map , HttpStatus.OK);
	}
	
	@RequestMapping(value="/restaurant" , method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> findRestaurant(){
		ArrayList<Restaurant> Restaurant = restaurantService.findAll();

		Map<String, Object> map = new HashMap<>();
		map.put("CODE","200");
		map.put("MESSAGE","RECORDS FOUND!");
		map.put("DATA", Restaurant);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
}
