package org.khmeracademy.rest.pp.controller;

import java.util.HashMap;
import java.util.Map;

import org.khmeracademy.rest.pp.entity.User;
import org.khmeracademy.rest.pp.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLoginController {

	@Autowired
	private UserLoginService userLoginService;
	
	/*@RequestMapping(value="/login", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> loadUserByEmail(@RequestParam("email")String email){
		User userlogin = userLoginService.loadUserByEmail(email);
		System.out.println("==> Login User: " + userlogin);
		Map<String, Object> map = new HashMap<>();
		map.put("CODE", "200");
		map.put("MESSAGE", "RECODE FOUND!");
		map.put("DATA", userlogin);
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}*/
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public User loadUserByEmail(@RequestParam("email")String email){
		User userlogin = userLoginService.loadUserByEmail(email);
		System.out.println("==> Login User: " + userlogin);
		return userlogin;
	}
	/*@RequestMapping(value="/login", method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> save(@RequestBody User user){
		Map<String, Object> map = new HashMap<>();
		try{
			if(userLoginService.save(user)){
				map.put("MESSAGE", "User has been inserted.");
				map.put("STATUS", true);
			}else {
				map.put("MESSAGE", "User has not been inserted.");
				map.put("STATUS", false);
			}
			
		}catch(Exception e){
			map.put("MESSAGE", "ERROR!");
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/login/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Map<String, Object>> remove(@PathVariable("id") int id){
		Map<String, Object> map = new HashMap<>();
		boolean status = userLoginService.remove(id);
		try{
			if(status){
				map.put("MESSAGE", "User has been deleted");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "User has not been deleted.");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			map.put("STATUS", false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/slide", method=RequestMethod.PUT)
	public ResponseEntity<Map<String, Object>> update(@RequestBody User user){
		Map<String, Object> map = new HashMap<>();
		try{
			if(userLoginService.update(user)){
				map.put("MESSAGE", "User has been updated.");
				map.put("STATUS", true);
			}else{
				map.put("MESSAGE", "User has not been updated");
				map.put("STATUS", false);
			}
		}catch(Exception e){
			e.printStackTrace();
			map.put("MESSAGE", "ERROR!");
			map.put("STATUS", false);
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}*/
	
	
}
