package com.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.pojo.EarthQuake;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年9月29日
 * @description 数据库操作Util,其中包括查表和查表对比操作
 */

public class OperationEth {
	/**
	 * 新增一条地震信息
	 * 
	 * @param location
	 * @param earthQuake
	 * @throws Exception
	 */
	public void insert(String location, EarthQuake earthQuake) throws Exception {
		DataBaseConnect conn = new DataBaseConnect();
		String sql = "insert into " + location + " (place_name,longitude,latitude,mag,depth,time) values ('"
				+ earthQuake.getPlaceName() + "','" + earthQuake.getLongitude() + "','" + earthQuake.getLatitude()
				+ "'," + earthQuake.getMag() + ",'" + earthQuake.getDepth() + "','" + earthQuake.getTime() + "')";
		conn.executeUpdate(sql);
		conn.free();
		System.out.println("\n新增一条地震信息:");
	}

	/**
	 * 比较地震信息，如果有就不进行插表操作，如果没有就新增一条地震信息
	 * 
	 * @param location
	 * @param earthQuake
	 * @throws Exception
	 */
	public Boolean compare(String location, EarthQuake earthQuake) throws Exception {
		Boolean same = false;
		DataBaseConnect conn = new DataBaseConnect();
		String sql = "select * from " + location + " where latitude = '" + earthQuake.getLatitude()
				+ "' and longitude = '" + earthQuake.getLongitude() + "'";
		ResultSet rs = conn.executeQuery(sql);
		while (rs.next()) {
			float mag = rs.getFloat("mag");
			String depth = rs.getString("depth");
			if (mag == earthQuake.getMag() && depth.equals(earthQuake.getDepth())) {
				same = true;
				System.out.println("\n(" + rs.getString("latitude") + "," + rs.getString("longitude") + ",M "
						+ rs.getFloat("mag") + "," + rs.getString("depth") + ")与已有的信息重复！");
			}
		}
		conn.free();
		return same;
	}

	/**
	 * 打印地震信息
	 * 
	 * @param earthQuake
	 */
	public void printEth(int i, EarthQuake earthQuake) {
		System.out.println(i + " ->[ 地名:" + earthQuake.getPlaceName() + ",纬度:" + earthQuake.getLatitude() + ",经度:"
				+ earthQuake.getLongitude() + ",震级:M " + earthQuake.getMag() + ",范围:" + earthQuake.getDepth() + ",时间:"
				+ earthQuake.getTime() + " ]");
	}
}
