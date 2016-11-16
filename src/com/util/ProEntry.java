package com.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年11月16日
 * @description 处理每条地震信息转化成规定的数据格式，用于写入txt文件中
 */

public class ProEntry {
	DecimalFormat fnum = new DecimalFormat("##0.00");

	/**
	 * @param time
	 * @return 時間戳
	 */
	public String proTime(String time) {
		String re = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
		time = time.replace("/", "-");
		String[] st = time.split(":");
		if (st.length < 3) {
			time += ":00";
		}
		Date data = null;
		try {
			data = sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		re = "" + data.getTime();
		return re;
	}

	/**
	 * @param longitude
	 * @return 經度
	 */
	public String proLongitude(String longitude) {
		String re = "";
		try {
			float lo = Float.parseFloat(longitude.substring(0, longitude.indexOf("°")));
			if (longitude.contains("W")) {
				re = "-" + fnum.format(lo).toString();
			} else {
				re = "" + fnum.format(lo).toString();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return re;
	}

	/**
	 * @param latitude
	 * @return 緯度
	 */
	public String proLatitude(String latitude) {
		String re = "";
		try {
			float la = Float.parseFloat(latitude.substring(0, latitude.indexOf("°")));
			if (latitude.contains("S")) {
				re = "-" + fnum.format(la).toString();
			} else {
				re = "" + fnum.format(la).toString();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return re;
	}

	/**
	 * @param depth
	 * @return 震深0~100
	 */
	public String proDepth(String depth) {
		String re = "";
		try {
			float de = Float.parseFloat(depth.split(" ")[0]);
			re = "" + de;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return re;
	}

	/**
	 * @param mag
	 * @return 震級0~10
	 */
	public String proMag(float mag) {
		String re = "";
		float ma = mag;
		re = "" + ma;
		return re;
	}
}
