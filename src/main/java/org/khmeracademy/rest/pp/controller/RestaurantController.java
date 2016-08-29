package org.khmeracademy.rest.pp.controller;

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
import org.khmeracademy.rest.pp.filter.RestaurantFilter;
import org.khmeracademy.rest.pp.service.FileUploadService;
import org.khmeracademy.rest.pp.service.RestaurantService;
import org.khmeracademy.rest.pp.utilities.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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

	@Autowired
	FileUploadService fileUploadService;

	@RequestMapping(value = "/restaurant", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> saveRestaurant(UploadRest uploadRest, HttpServletRequest request) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			RestImgFile restImage = fileUploadService.upload(uploadRest.getImage(), "Restaurant_Image", request);
			List<Menu> menus = new ArrayList<>();

			for (String str : restImage.getNames()) {
				Menu m = new Menu(0, 0, null, restImage.getProjectPath() + str);
				menus.add(m);
			}
			List<Images> images = new ArrayList<>();

			RestImgFile menuImage = fileUploadService.upload(uploadRest.getMenus(), "Restaurant_Image", request);
			for (String str1 : menuImage.getNames()) {
				Images img = new Images();
				img.setUrl(menuImage.getProjectPath() + str1);
				images.add(img);
			}
			List<Telephone> tels = new ArrayList<>();
			for (String tel : uploadRest.getTelephones()) {
				Telephone telephone = new Telephone(0, 0, tel);
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
			rest.setTelephone(tels);
			rest.setProvince(uploadRest.getProvince());
			rest.setCreate_date(uploadRest.getCreate_date());
			rest.setLatitude(uploadRest.getLatitude());
			rest.setLongitude(uploadRest.getLongitude());

			rest.setMenus(menus);
			rest.setImages(images);

			try {
				int id = restaurantService.save(rest);
				map.put("MESSAGE", "User has been inserted.");
				map.put("STATUS", true);
				// map.put("ID", id);

			} catch (Exception e) {
				map.put("MESSAGE", "ERROR!");
				map.put("STATUS", false);
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	@RequestMapping(value = "/restaurant/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Map<String, Object>> delelteCategory(@PathVariable("id") int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean status = restaurantService.remove(id);
		try {
			if (status) {
				map.put("MESSAGE", "User has been deleted");
				map.put("STATUS", true);
			} else {
				map.put("MESSAGE", "User has not been deleted");
				map.put("STATUS", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("STATUS", false);
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	@RequestMapping(value="/restaurantUpdate" , method = RequestMethod.POST)
	public ResponseEntity<Map<String , Object>> updateRestaurant(UploadRest  uploadRest, HttpServletRequest request){

		Map<String , Object> map = new HashMap<String , Object>();
		try{
		
			List<Menu> menus = new ArrayList<>();
			if(uploadRest.getMenus()!= null && !uploadRest.getMenus().isEmpty()){
				RestImgFile menuImage = fileUploadService.upload(uploadRest.getMenus(), "Restaurant_Image", request);
			
				for (String str  : menuImage.getNames()) {
					Menu m = new Menu(0, 0, null, menuImage.getProjectPath() + str);
					menus.add(m);
				}		
			}
			
			List<Images> images = new ArrayList<>();
			if(uploadRest.getImage() != null && !uploadRest.getImage().isEmpty()){
				RestImgFile restImage = fileUploadService.upload(uploadRest.getImage(), "Restaurant_Image", request);
				for(String str1 : restImage.getNames()){
					Images img = new Images();
					img.setUrl(restImage.getProjectPath() + str1);
					images.add(img);
				}
			}
			
			List<Telephone> tels = new ArrayList<>();
			for(String tel : uploadRest.getTelephones()){
				Telephone telephone = new Telephone(0,0, tel);
				tels.add(telephone);
			}
			
			if(uploadRest.getDeletedImageIds() != null && !uploadRest.getDeletedImageIds().isEmpty()){
				if(restaurantService.deleteRestaurantImage(uploadRest.getDeletedImageIds())){
					System.out.println("Image Deleted");
				} else{
					System.out.println("Image Failed");
				}
			}
			
			if(uploadRest.getDeletedMenuIds() != null && !uploadRest.getDeletedMenuIds().isEmpty()){
				if(restaurantService.deleteMenuImage(uploadRest.getDeletedMenuIds())){
					System.out.println("Menu Deleted");
				} else{
					System.out.println("Menu Failed");
				}
			}
			
			Restaurant rest = new Restaurant();
			rest.setId(uploadRest.getId());
			rest.setName(uploadRest.getName());
			rest.setDesc(uploadRest.getDescription());
			rest.setDelivery(uploadRest.getDelivery());
			rest.setCommune(uploadRest.getCommune());
			rest.setDistrict(uploadRest.getDistrict());
			rest.setHome(uploadRest.getHome());
			rest.setStreet(uploadRest.getStreet());
			rest.setSub_id(uploadRest.getType());
			rest.setTelephone(tels);
			rest.setProvince(uploadRest.getProvince());
			rest.setCreate_date(uploadRest.getCreate_date());
			rest.setLatitude(uploadRest.getLatitude());
			rest.setLongitude(uploadRest.getLongitude());
			
			rest.setMenus(menus);
			rest.setImages(images);
			
			try{
				boolean status = restaurantService.update(rest);
				
				if(status){
				map.put("MESSAGE", "User has been inserted.");
					map.put("STATUS", true);
				}
			}catch(Exception e){
				map.put("MESSAGE", "ERROR!");
				map.put("STATUS", false);
				e.printStackTrace();
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map , HttpStatus.OK);

	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", defaultValue = "1", value = "Results page you want to retrieve (1..N)"),
			@ApiImplicitParam(name = "limit", dataType = "integer", paramType = "query", defaultValue = "12", value = "Number of records per page."),
			@ApiImplicitParam(name = "name", dataType = "string", paramType = "query", defaultValue = "", value = "Number of records per page."),
			@ApiImplicitParam(name = "c_id", dataType = "string", paramType = "query", defaultValue = "", value = "Number of records per page."),
			@ApiImplicitParam(name = "type_id", dataType = "string", paramType = "query", defaultValue = "", value = "Number of records per page."),
			@ApiImplicitParam(name = "province", dataType = "string", paramType = "query", defaultValue = "", value = "Number of records per page."),
			@ApiImplicitParam(name = "district", dataType = "string", paramType = "query", defaultValue = "", value = "District."),
			@ApiImplicitParam(name = "commune", dataType = "string", paramType = "query", defaultValue = "", value = "Commune.") })
	@RequestMapping(value = "/restaurant", method = RequestMethod.GET)
	// public ResponseEntity<Map<String,Object>>
	// findRestaurant(@RequestParam("limit") int limit , @RequestParam("page")
	// int page){
	//
	public ResponseEntity<Map<String, Object>> findRestaurant(@ApiIgnore RestaurantFilter filter,
			@ApiIgnore Pagination pagination) {

		// Pagination pagination = new Pagination();
		// pagination.setPage(page);
		// pagination.setLimit(limit);
		pagination.setTotalCount(restaurantService.CountfindAll(filter));
		// restaurantService.

		ArrayList<Restaurant> Restaurant = restaurantService.findAll(filter.getProvince(), filter, pagination);
		Map<String, Object> map = new HashMap<>();
		map.put("CODE", "200");
		map.put("MESSAGE", "RECORDS FOUND!");
		map.put("DATA", Restaurant);
		map.put("Pagination", pagination);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	@RequestMapping(value = "/restaurant/{id}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> findRestByID(@PathVariable("id") int id) {
		ArrayList<Restaurant> Restaurant = restaurantService.findByRestId(id);

		Map<String, Object> map = new HashMap<>();
		map.put("CODE", "200");
		map.put("MESSAGE", "RECORDS FOUND!");
		map.put("DATA", Restaurant);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	@RequestMapping(value = "/restaurant/category/{id}", method = RequestMethod.GET)
	// @ApiImplicitParams({
	// @ApiImplicitParam(name="page", paramType="query", defaultValue="1"),
	// @ApiImplicitParam(name="limit", paramType="query", defaultValue="15")
	// })

	// public ResponseEntity<Map<String,Object>>
	// findRestByCategoryId(@PathVariable("id") int id, @ApiIgnore Pagination
	// pagination){
	//
	public ResponseEntity<Map<String, Object>> findRestByCategoryId(@PathVariable("id") int id, Pagination pagination) {
		ArrayList<Restaurant> Restaurant = restaurantService.findByCategoryId(id, pagination);
		pagination.setTotalCount(restaurantService.countFindByCatID(id));
		Map<String, Object> map = new HashMap<>();
		map.put("CODE", "200");
		map.put("MESSAGE", "RECORDS FOUND!");
		map.put("DATA", Restaurant);
		map.put("Pagination", pagination);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	@RequestMapping(value = "/restaurant/type/{id}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> findRestByTypeId(@PathVariable("id") int id, Pagination pagination) {
		pagination.setTotalCount(restaurantService.countFindByTypeID(id));
		ArrayList<Restaurant> Restaurant = restaurantService.findByTypeId(id, pagination);

		Map<String, Object> map = new HashMap<>();
		map.put("CODE", "200");
		map.put("MESSAGE", "RECORDS FOUND!");
		map.put("DATA", Restaurant);
		map.put("Pagination", pagination);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
//	*************FIND By AddToFavorite************
	@RequestMapping(value = "/restaurant/user/save/{id}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> findByAddToFavorite(@PathVariable("id") int id, Pagination pagination) {
		pagination.setTotalCount(restaurantService.countFindByAddToFavorite(id));
		ArrayList<Restaurant> Restaurant = restaurantService.findByAddToFavorite(id, pagination);
		Map<String, Object> map = new HashMap<>();
		map.put("CODE", "200");
		map.put("MESSAGE", "RECORDS FOUND!");
		map.put("DATA", Restaurant);
		map.put("Pagination", pagination);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	
}
