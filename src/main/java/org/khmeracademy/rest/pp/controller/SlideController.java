package org.khmeracademy.rest.pp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.khmeracademy.rest.pp.entity.Slide;
import org.khmeracademy.rest.pp.service.SlideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SlideController {

	@Autowired 
	private SlideService slideService;
	
	@RequestMapping(value="/slide", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>>findAll(){
		ArrayList<Slide> slide = slideService.findAll();
		
		Map<String, Object> map = new HashMap<>();
		map.put("CODE", "200");
		map.put("MESSAGE", "RECODES FOUND!");
		map.put("DATA", slide);
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK) ;
	}
	
	@RequestMapping(value="/slide", method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> save(@RequestBody Slide slide){
		Map<String, Object> map = new HashMap<>();
		try{
			if(slideService.save(slide)){
				map.put("MESSAGE", "Slide has been inserted.");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "Slide has not been inserted.");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("MESSAGE", "ERROR!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/slide{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Map<String, Object>> remove(@PathVariable("id") int id){
		Map<String, Object> map = new HashMap<>();
		boolean status = slideService.remove(id);
		try{
			if(status){
				map.put("MESSAGE", "Slide has been deleted");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "Slide has not been deleted.");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/slide", method=RequestMethod.PUT)
	public ResponseEntity<Map<String, Object>> update(@RequestBody Slide slide){
		Map<String, Object> map = new HashMap<>();
		try{
			if(slideService.update(slide)){
				map.put("MESSAGE", "Slide has been updated.");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "Slide has not been updated");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			e.printStackTrace();
			map.put("MESSAGE", "ERROR!");
			map.put("STATUS", false);
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	
}