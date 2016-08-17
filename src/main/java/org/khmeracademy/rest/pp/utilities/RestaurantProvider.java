package org.khmeracademy.rest.pp.utilities;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.khmeracademy.rest.pp.filter.RestaurantFilter;

public class RestaurantProvider {
//
//	public static String findAll(Map<String, Object> param) {
//		RestaurantFilter filter = (RestaurantFilter) param.get("filter");
//		String sql = new SQL() {
//			{
//				SELECT("R.rest_id, R_name, R.description, R.delivery, R.c_id, R.province,R.district,R.commune,R.create_date,"
//						+ "I.");
//				FROM("rest_restaurant R");
//				INNER_JOIN("rest_rest_image I ON I.rest_id = R.rest_id");
//				INNER_JOIN("rest_menu M ON M.rest_id = R.rest_id");
//				INNER_JOIN("rest_telephone T ON T.rest_id = R.rest_id");
//
//				if (filter.getName() != null) {
//					WHERE("R.name LIKE '%' || #{filter.name} || '%'");
//				}
//
//				if (filter.getId() != null) {
//					WHERE("R.role_id = #{filter.roleId}");
//				}
//
//				ORDER_BY("R.rest_id DESC OFFSET #{pagination.offset} LIMIT #{pagination.limit}");
//			}
//		}.toString();
//
//		return sql;
//	}
//
//	public static String count(Map<String, Object> param) {
//		RestaurantFilter filter = (RestaurantFilter) param.get("filter");
//		return new SQL() {
//			{
//				SELECT("COUNT(rest_id)");
//				FROM("rest_restaurant R");
//				INNER_JOIN("rest_rest_image I ON I.rest_id = R.rest_id");
//				INNER_JOIN("rest_menu M ON M.rest_id = R.rest_id");
//				INNER_JOIN("rest_telephone T ON T.rest_id = R.rest_id");
//				if (filter.getName() != null) {
//					WHERE("R.name LIKE '%' || #{filter.name} || '%'");
//				}
//				if (filter.getId() != null) {
//					WHERE("R.role_id = #{filter.roleId}");
//				}
//			}
//		}.toString();
//	}
}
