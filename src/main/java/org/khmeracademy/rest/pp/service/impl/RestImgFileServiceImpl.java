package org.khmeracademy.rest.pp.service.impl;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.khmeracademy.rest.pp.entity.RestImgFile;
import org.khmeracademy.rest.pp.service.RestImgFileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

//import file.util.Console;

@Service
public class RestImgFileServiceImpl implements RestImgFileService {

	@Override
	public RestImgFile upload(List<MultipartFile> files, String folder, HttpServletRequest request) {
		RestImgFile fileUpload = new RestImgFile();

		if(files.isEmpty()){
			//Console.logError("File is empty!");
			fileUpload.setMessage("File is not present! Please choose file to upload!!!");
			
		}else{
			if(folder=="" || folder==null)
				folder = "default";
			String serverPath = request.getServletContext().getRealPath("/resources/");
			System.out.println(serverPath);
			String UPLOAD_PATH = serverPath + folder;
			
			java.io.File path = new java.io.File(UPLOAD_PATH);
			if(!path.exists())
				path.mkdirs();
			
			List<String> names = new ArrayList<>();
			for(MultipartFile file: files){
				String fileName = file.getOriginalFilename();
				fileName = UUID.randomUUID() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
				try {
					Files.copy(file.getInputStream(), Paths.get(UPLOAD_PATH, fileName));
					names.add(fileName);
				} catch (Exception e) { 
					//Console.logError(e);
					fileUpload.setMessage("Fail to upload!, " + e.getMessage());
				}
			}
			fileUpload.setProjectPath("/resources/" + folder);
			fileUpload.setServerPath(UPLOAD_PATH);
			fileUpload.setNames(names);
			fileUpload.setMessage("File has been uploaded successfully!!!");
		}
		return fileUpload;
		
	}

}
