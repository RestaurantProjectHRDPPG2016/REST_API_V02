package org.khmeracademy.rest.pp.service.impl;

import java.util.ArrayList;

import org.khmeracademy.rest.pp.entity.SubCategory;
import org.khmeracademy.rest.pp.repository.SubCategoryRepository;
import org.khmeracademy.rest.pp.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SubCategoryServiceImpl implements SubCategoryService {
	@Autowired
	private SubCategoryRepository subCategoryRepository;
	@Override
	public boolean remove(int id) {
		return subCategoryRepository.remove(id);
	}

	@Override
	public boolean save(SubCategory subCategory) {
		return subCategoryRepository.save(subCategory);
	}

	@Override
	public boolean update(SubCategory subCategory) {
		return subCategoryRepository.update(subCategory);
	}

	@Override
	public ArrayList<SubCategory> findAll() {
		return subCategoryRepository.findAll();
	}

}
