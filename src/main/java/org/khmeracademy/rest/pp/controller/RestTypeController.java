package org.khmeracademy.rest.pp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.khmeracademy.rest.pp.entity.RestType;
import org.khmeracademy.rest.pp.service.RestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTypeController {
	@Autowired
	private RestTypeService restTypeService;

	@RequestMapping(value="/resttype", method= RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> findAll(){
		ArrayList<RestType> restType = restTypeService.findAll();

		Map<String, Object> map = new HashMap<>();
		map.put("CODE","200");
		map.put("MESSAGE","RECORDS FOUND!");
		map.put("DATA", restType);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
}
	@RequestMapping(value="/resttype" , method = RequestMethod.POST)
	public ResponseEntity<Map<String , Object>> save(@RequestBody RestType restType){
		Map<String , Object> map = new HashMap<String , Object>();
		try{
			if(restTypeService.save(restType)){
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
	@RequestMapping(value="/resttype/{id}" , method = RequestMethod.DELETE )
	public ResponseEntity<Map<String, Object>> remove(@PathVariable("id") int id){
		Map<String , Object> map = new HashMap<String , Object>();
		boolean status = restTypeService.remove(id);
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
	

	@RequestMapping(value="/resttype",method=RequestMethod.PUT)
	public ResponseEntity<Map<String, Object>> update(@RequestBody RestType restType){
		Map<String, Object> map = new HashMap<String , Object>();
		try{
			if(restTypeService.update(restType)){
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
	
}
