package org.khmeracademy.rest.pp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.khmeracademy.rest.pp.entity.Location;
import org.khmeracademy.rest.pp.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {

	@Autowired
	private LocationService locationService;
	
	@RequestMapping(value="/locations", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> findAllLocation(){
		ArrayList<Location> location = locationService.findAllLocation();
		
		Map<String, Object> map = new HashMap<>();
		map.put("CODE", "200");
		map.put("MESSAGE", "RECODES FOUND!");
		map.put("DATA", location);
		
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
//	
//	@RequestMapping(value="/locations", method=RequestMethod.POST)
//	public ResponseEntity<Map<String, Object>> saveLocation(Location location){
//		
//		Map<String, Object> map = new HashMap<>();
//		try{
//			if(locationService.saveLocation(location)){
//				map.put("MESSAGE", "Location has been saved.");
//				map.put("STATUS", true);
//				map.put("DATA", location);
//			}else{
//				map.put("MESSAGE", "Location has not been saved.");
//				map.put("STATUS", false);
//			}
//		}catch(Exception e){
//			map.put("MESSAGE", "ERROR!");
//			map.put("STATUS", false);
//			e.printStackTrace();
//		}
//	
//		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
//	}
//	
//	@RequestMapping(value="/locations/{id}", method=RequestMethod.DELETE)
//	public ResponseEntity<Map<String, Object>> deleteLocation(@PathVariable("id") int id){
//		Map<String, Object> map = new HashMap<>();
//		try{
//			if(locationService.deleteLocation(id)){
//				map.put("MESSAGE", "Location has been deleted!");
//				map.put("STATUS", true);
//			}else{
//				map.put("MESSAGE", "Location has not been deleted!");
//				map.put("STATUS", false);
//			}
//		}catch(Exception e){
//			map.put("MESSAGE", "ERROR!");
//			map.put("STATUS", false);
//			e.printStackTrace();
//		}
//
//		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
//	}
//	
//	@RequestMapping(value="/locations", method= RequestMethod.PUT)
//	public ResponseEntity<Map<String, Object>> updateLocation(@RequestBody Location location){
//		
//		Map<String, Object> map = new HashMap<>();
//		try{
//			if(locationService.updateLocation(location)){
//				map.put("MESSAGE", "Location has been updated!");
//				map.put("STATUS", true);
//			}else{
//				map.put("MESSAGE", "Location has not been updated!");
//				map.put("STATUS", false);
//			}
//		}catch(Exception e){
//			map.put("MESSAGE", "ERROR!");
//			map.put("STATUS", false);
//			e.printStackTrace();
//		}
//		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
//	}
	
}
