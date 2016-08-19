package org.khmeracademy.rest.pp.service;
import java.util.ArrayList;
import org.khmeracademy.rest.pp.entity.Slide;

public interface SlideService {

	ArrayList<Slide> findAll();
	boolean save(Slide slide);
	boolean remove(int id);
	boolean update(Slide slide);
	
}
