package org.khmeracademy.rest.pp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.khmeracademy.rest.pp.entity.SubCategory;
import org.khmeracademy.rest.pp.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubCategoryController {
	@Autowired 
	private SubCategoryService subCategoryService;
	@RequestMapping(value="/subcategory", method= RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> findAll(){
		ArrayList<SubCategory> mainCategory = subCategoryService.findAll();

		Map<String, Object> map = new HashMap<>();
		map.put("CODE","200");
		map.put("MESSAGE","RECORDS FOUND!");
		map.put("DATA", mainCategory);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	@RequestMapping(value="/subcategory" , method = RequestMethod.POST)
	public ResponseEntity<Map<String , Object>> save(@RequestBody SubCategory subCategory){
		Map<String , Object> map = new HashMap<String , Object>();
		try{
			if(subCategoryService.save(subCategory)){
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
	
	@RequestMapping(value="/subcategory/{id}" , method = RequestMethod.DELETE )
	public ResponseEntity<Map<String, Object>> remove(@PathVariable("id") int id){
		Map<String , Object> map = new HashMap<String , Object>();
		boolean status = subCategoryService.remove(id);
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
	@RequestMapping(value="subcategory",method=RequestMethod.PUT)
	public ResponseEntity<Map<String, Object>> update(@RequestBody SubCategory subCategory){
		Map<String, Object> map = new HashMap<String , Object>();
		try{
			if(subCategoryService.update(subCategory)){
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
