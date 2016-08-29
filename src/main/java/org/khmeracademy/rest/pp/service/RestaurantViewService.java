package org.khmeracademy.rest.pp.service;

import java.util.ArrayList;

import org.khmeracademy.rest.pp.entity.RestaurantView;

public interface RestaurantViewService {
	boolean save(int id);
	ArrayList<RestaurantView> findViewByRestId(int id);
	
}
