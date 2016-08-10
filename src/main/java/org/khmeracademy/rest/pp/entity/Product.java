package org.khmeracademy.rest.pp.entity;

import java.util.List;

public class Product {
	private int id;
	private int r_id;
	private String name;
	private String detail;
	private double price;
	private String date;
	private String video;
	private List<ProImage> proImage;
	private List<ProType> proType;
}
