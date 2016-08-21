package org.khmeracademy.rest.pp.service.impl;

import java.util.ArrayList;

import org.khmeracademy.rest.pp.entity.Slide;
import org.khmeracademy.rest.pp.repository.SlideRepository;
import org.khmeracademy.rest.pp.service.SlideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SlideServiceImpl implements SlideService {

	@Autowired 
	private SlideRepository slideRepository;

	@Override
	public ArrayList<Slide> findAll() {
		return slideRepository.findAll();
	}

	@Override
	public boolean save(Slide slide) {
		return slideRepository.save(slide);
	}

	@Override
	public boolean remove(int id) {
		return slideRepository.remove(id);
	}

	@Override
	public boolean update(Slide slide) {
		return slideRepository.update(slide);
	}
	
}
