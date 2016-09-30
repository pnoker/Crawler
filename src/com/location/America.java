package com.location;

import java.sql.ResultSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.util.DataBaseConnect;

public class America {
	public void content(String url) throws Exception {
		DataBaseConnect conn = new DataBaseConnect();
		String sql = "";
		Document doc2 = Jsoup.connect(url).timeout(20000).get();
		Elements entry = doc2.select("entry");
		for (int m = 0; m < entry.size(); m++) {
			String title = entry.get(m).select("title").text();
			String placeName = title.substring(title.indexOf("-")+2);
			float mag = Float.parseFloat(title.split(" ")[1]);
			String updated = entry.get(m).select("updated").text();
			Element summary = entry.get(m).select("summary").first();
			Document html = Jsoup.parse(summary.text());
			Elements dd = html.select("dd");
			String time = dd.get(0).text().substring(0,dd.get(0).text().indexOf("UTC")-1);
			String longitude = dd.get(2).text().split(" ")[1];
			String latitude = dd.get(2).text().split(" ")[0];
			String depth = dd.get(3).text();
			System.out.println("\n第" + (m + 1) + "行数据：");
			System.out.print("[");
			System.out.print(title + ",");
			System.out.print(updated + ",");
			System.out.print(dd.get(0).text() + ",");
			System.out.print(dd.get(2).text() + ",");
			System.out.print(dd.get(3).text());
			System.out.print("]");
			sql = "insert into american (place_name,longitude,latitude,mag,depth,time) values ('"+placeName+"','"+longitude+"','"+latitude+"',"+mag+",'"+depth+"','"+time+"')";
			conn.executeUpdate(sql);
		}
	}
}
