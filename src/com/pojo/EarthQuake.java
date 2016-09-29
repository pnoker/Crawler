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
