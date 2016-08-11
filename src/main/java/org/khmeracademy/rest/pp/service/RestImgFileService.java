package org.khmeracademy.rest.pp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.khmeracademy.rest.pp.entity.RestImgFile;
import org.springframework.web.multipart.MultipartFile;


public interface RestImgFileService {
	/***
	 * Upload to default location
	 */
	public RestImgFile upload(List<MultipartFile> files, String folder, HttpServletRequest request);
}
