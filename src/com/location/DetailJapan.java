package com.location;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.pojo.Detail;
import com.util.StringFormat;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年9月30日
 * @description
 */

public class DetailJapan {
	public Detail content(String url) throws Exception {
		Document doc = Jsoup.connect(url).timeout(20000).get();
		Element table = doc.getElementById("infobox");
		Element td = table.select("td").first();
		StringFormat sf = new StringFormat();
		String loca = sf.ToDBC(td.text()).substring(sf.ToDBC(td.text()).indexOf("("),
				sf.ToDBC(td.text()).indexOf(")") + 1);
		String latitude = loca.substring(loca.indexOf("(北緯") + 3, loca.indexOf("度、東経"))+"°N";
		String longitude = loca.substring(loca.indexOf("度、東経") + 4, loca.indexOf("度)"))+"°E";
		String depth = "";
		try {
			depth = sf.ToDBC(td.text()).substring(sf.ToDBC(td.text()).indexOf("震源の深さは約") + 7,
					sf.ToDBC(td.text()).indexOf("km")) + " Km";
		} catch (Exception e) {
			System.out.println("没有震深相关的信息！");
		}
		Detail detail = new Detail(longitude, latitude, depth);
		return detail;
	}
}
