package com.pojo;

/**
 * 经、纬度以及震深的详情，主要针对日本网站
 * 
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年9月30日
 * @description
 */

public class Detail {
	private String longitude;
	private String latitude;
	private String depth;

	public Detail() {
		super();
	}

	/**
	 * 构造函数，经度，纬度，震深
	 * @param longitude
	 * @param latitude
	 * @param depth
	 */
	public Detail(String longitude, String latitude, String depth) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
		this.depth = depth;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getDepth() {
		return depth;
	}

	public void setDepth(String depth) {
		this.depth = depth;
	}

}
