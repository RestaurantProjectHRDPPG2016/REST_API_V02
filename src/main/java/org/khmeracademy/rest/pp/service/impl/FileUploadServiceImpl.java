package org.khmeracademy.rest.pp.service.impl;



import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.khmeracademy.rest.pp.entity.RestImgFile;
import org.khmeracademy.rest.pp.service.FileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/***
 * Create Date: 8/8/2016 02:00PM
 * @author PHEARUN
 */

@Service
public class FileUploadServiceImpl implements FileUploadService{
	
	@Override
	public RestImgFile upload(List<MultipartFile> files, String folder) {
		
		RestImgFile fileUpload = new RestImgFile();
		
		if(files.isEmpty()){
			fileUpload.setMessage("File is not present! Please choose file to upload!!!");
			
		}else{
			
			if(folder=="" || folder==null)
				folder = "default";
			String UPLOAD_PATH = "/opt/project/" + folder;
			
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

	@Override
	public RestImgFile upload(MultipartFile file, String folder) {
		List<MultipartFile> files = new ArrayList<>();
		files.add(file);
		return this.upload(files, folder);
	}

	@Override
	public RestImgFile upload(List<MultipartFile> files, String folder, HttpServletRequest request) {
		
		RestImgFile fileUpload = new RestImgFile();
		
		if(files.isEmpty()){
			fileUpload.setMessage("File is not present! Please choose file to upload!!!");
		}else{
			if(folder=="" || folder==null)
				folder = "DEFAULT";
			
			String PROJECT_PATH = "/resources/MOL/UPLOAD/" + folder;
			String UPLOAD_PATH = request.getServletContext().getRealPath(PROJECT_PATH);
			
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
					fileUpload.setMessage("Fail to upload!, " + e.getMessage());
				}
			}
			fileUpload.setProjectPath(PROJECT_PATH);
			fileUpload.setServerPath(UPLOAD_PATH);
			fileUpload.setNames(names);
			fileUpload.setMessage("File has been uploaded successfully!!!");
		}
		return fileUpload;
	}

	
}
