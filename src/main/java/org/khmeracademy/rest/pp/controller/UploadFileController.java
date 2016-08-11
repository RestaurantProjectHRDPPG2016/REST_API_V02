package org.khmeracademy.rest.pp.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@RestController
public class UploadFileController {

	@RequestMapping(method = RequestMethod.POST, value = "/upload")
	public ResponseEntity<Map<String, Object>> uploadfile(
			@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		String ramdom_file_name="";
		try {
			
			String savePath = request.getSession().getServletContext().getRealPath("/resources/upload/playlist/");
			UploadFile fileName = new UploadFile();
			if (file == null) {
				map.put("STATUS", false);
				map.put("MESSAGE", "IMAGE HAS NOT BEEN INSERTED");
				return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
			} else {
				ramdom_file_name = UUID.randomUUID() + ".jpg";
				String CategoryImage = fileName.UploadFiles(file, savePath,"",ramdom_file_name);
				map.put("STATUS", true);
				map.put("MESSAGE", "IMAGE HAS BEEN INSERTED");
				map.put("IMG", CategoryImage);
				return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("MESSAGE", "OPERATION FAIL");
			map.put("STATUS", false);
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

	}
}
