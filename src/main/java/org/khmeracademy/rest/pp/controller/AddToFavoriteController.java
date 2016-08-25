package org.khmeracademy.rest.pp.controller;

import java.util.HashMap;
import java.util.Map;

import org.khmeracademy.rest.pp.entity.AddToFavorite;
import org.khmeracademy.rest.pp.service.AddToFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class AddToFavoriteController {
	
	@Autowired
	private AddToFavoriteService addToFavoriteService;
	@RequestMapping(value="/addtofavorite" , method = RequestMethod.POST)
	public ResponseEntity<Map<String , Object>> save(@RequestBody AddToFavorite addToFavorite ){
		Map<String , Object> map = new HashMap<String , Object>();
		try{
			if(addToFavoriteService.save(addToFavorite)){
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
	
}
