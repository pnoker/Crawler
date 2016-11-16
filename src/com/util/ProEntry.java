package com.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年11月16日
 * @description
 */

public class ProEntry {
	DecimalFormat fnum = new DecimalFormat("##0.00");

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

	public String proLongitude(String longitude) {
		String re = "";
		float lo = Float.parseFloat(longitude.substring(0, longitude.indexOf("°")));
		if (longitude.contains("W")) {
			re = "-" + fnum.format(lo).toString();
		} else {
			re = "" + fnum.format(lo).toString();
		}
		return re;
	}

	public String proLatitude(String latitude) {
		String re = "";
		float la = Float.parseFloat(latitude.substring(0, latitude.indexOf("°")));
		if (latitude.contains("S")) {
			re = "-" + fnum.format(la).toString();
		} else {
			re = "" + fnum.format(la).toString();
		}
		return re;
	}

	public String proDepth(String depth) {
		String re = "";
		float de = Float.parseFloat(depth.split(" ")[0]);
		re = "" + de;
		return re;
	}

	public String proMag(float mag) {
		String re = "";
		float ma = mag;
		re = "" + ma;
		return re;
	}
}
