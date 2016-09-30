package com.pojo;

import java.util.Date;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年9月29日
 * @description 一条地震的完整信息
 */

public class EarthQuake {
	private String placeName;
	private String latitude;
	private String longitude;
	private float mag;
	private String depth;
	private String time;

	/**
	 * 无参构造函数
	 */
	public EarthQuake() {
		super();
	}

	/**
	 * 有参构造函数
	 * 
	 * @param placeName
	 * @param latitude
	 * @param longitude
	 * @param mag
	 * @param depth
	 * @param time
	 */
	public EarthQuake(String placeName, String latitude, String longitude, float mag, String depth, String time) {
		super();
		this.placeName = placeName;
		this.latitude = latitude;
		this.longitude = longitude;
		this.mag = mag;
		this.depth = depth;
		this.time = time;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public float getMag() {
		return mag;
	}

	public void setMag(float mag) {
		this.mag = mag;
	}

	public String getDepth() {
		return depth;
	}

	public void setDepth(String depth) {
		this.depth = depth;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
