package org.khmeracademy.rest.pp.controller;

import java.awt.Image;
import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.khmeracademy.rest.pp.entity.Images;
import org.khmeracademy.rest.pp.entity.Menu;
import org.khmeracademy.rest.pp.entity.RestImgFile;
import org.khmeracademy.rest.pp.entity.Restaurant;
import org.khmeracademy.rest.pp.entity.Telephone;
import org.khmeracademy.rest.pp.entity.UploadRest;
import org.khmeracademy.rest.pp.service.FileUploadService;
import org.khmeracademy.rest.pp.service.RestaurantService;
import org.khmeracademy.rest.pp.utilities.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	FileUploadService fileUploadService;
	
	@RequestMapping(value="/restaurant" , method = RequestMethod.POST)
	public ResponseEntity<Map<String , Object>> saveRestaurant(UploadRest uploadRest, HttpServletRequest request){
		
		Map<String , Object> map = new HashMap<String , Object>();
		try{
		System.out.println(uploadRest);
		RestImgFile restImage = fileUploadService.upload(uploadRest.getImage(), "Restaurant_Image", request);
		List<Menu> menus = new ArrayList<>();
		
		for (String str  : restImage.getNames()) {
			System.out.println(restImage.getProjectPath() + str);
			Menu m = new Menu(0, 0, null, restImage.getProjectPath() + str);
			menus.add(m);
		}
		List<Images> images = new ArrayList<>();
		
		RestImgFile menuImage = fileUploadService.upload(uploadRest.getMenus(), "Restaurant_Image",request);
		for(String str1 : menuImage.getNames()){
				System.out.println(menuImage.getProjectPath() + str1);
				Images img = new Images();
				img.setUrl(menuImage.getProjectPath() + str1);
				images.add(img);
		}
		
		List<Telephone> tels = new ArrayList<>();
		for(String tel : uploadRest.getTelephones()){
			Telephone telephone = new Telephone(0,0, tel);
			tels.add(telephone);
		}
		
		
		Restaurant rest = new Restaurant();
		rest.setName(uploadRest.getName());
		rest.setDesc(uploadRest.getDescription());
		rest.setDelivery(uploadRest.getDelivery());
		rest.setCommune(uploadRest.getCommune());
		rest.setDistrict(uploadRest.getDistrict());
		rest.setHome(uploadRest.getHome());
		rest.setStreet(uploadRest.getStreet());
		rest.setSub_id(uploadRest.getType());
		rest.setTel(tels);
		rest.setProvince(uploadRest.getProvince());
		rest.setCreate_date(uploadRest.getCreate_date());
		rest.setLatitude(uploadRest.getLatitude());
		rest.setLongitude(uploadRest.getLongitude());
		
		rest.setMenus(menus);
		rest.setImages(images);
		
		try{
			int id = restaurantService.save(rest);
				map.put("MESSAGE", "User has been inserted.");
				map.put("STATUS", true);
				//map.put("ID", id);
			
		}catch(Exception e){
			map.put("MESSAGE", "ERROR!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
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
//	public ResponseEntity<Map<String,Object>> findRestaurant(@RequestParam("limit") int limit , @RequestParam("page") int page){
//		
	public ResponseEntity<Map<String,Object>> findRestaurant(Pagination pagination){
		
//		Pagination pagination = new Pagination();
//	    pagination.setPage(page);
//		pagination.setLimit(limit);
		pagination.setTotalCount(restaurantService.CountfindAll());
		//restaurantService.
		
		ArrayList<Restaurant> Restaurant = restaurantService.findAll(pagination);

		Map<String, Object> map = new HashMap<>();
		map.put("CODE","200");
		map.put("MESSAGE","RECORDS FOUND!");
		map.put("DATA", Restaurant);
		map.put("Pagination", pagination);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value="/restaurant/{id}" , method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> findRestByID(@PathVariable("id") int id){
		ArrayList<Restaurant> Restaurant = restaurantService.findByRestId(id);

		Map<String, Object> map = new HashMap<>();
		map.put("CODE","200");
		map.put("MESSAGE","RECORDS FOUND!");
		map.put("DATA", Restaurant);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/restaurant/category/{CategoryId}" , method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> findRestByCategoryId(@PathVariable("CategoryId") int CategoryId,Pagination pagination){
		ArrayList<Restaurant> Restaurant = restaurantService.findByCategoryId(CategoryId, pagination);

		Map<String, Object> map = new HashMap<>();
		map.put("CODE","200");
		map.put("MESSAGE","RECORDS FOUND!");
		map.put("DATA", Restaurant);
		map.put("Pagination", pagination);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	@RequestMapping(value="/restaurant/type/{TypeId}" , method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> findRestByTypeId(@PathVariable("TypeId") int TypeId, Pagination pagination){
		ArrayList<Restaurant> Restaurant = restaurantService.findByTypeId(TypeId, pagination);

		Map<String, Object> map = new HashMap<>();
		map.put("CODE","200");
		map.put("MESSAGE","RECORDS FOUND!");
		map.put("DATA", Restaurant);
		map.put("Pagination", pagination);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
}
