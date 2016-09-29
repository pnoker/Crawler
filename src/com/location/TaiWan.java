package com.location;

import java.awt.image.SampleModel;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.util.DataBaseConnect;

public class TaiWan {
	
	public void content(String url) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String year = sdf.format(new Date());
		DataBaseConnect conn = new DataBaseConnect();
		String sql = "";
		String[] text = new String[9];
		Document doc2 = Jsoup.connect(url).timeout(10000).get();
		Element table = doc2.getElementById("gvEvent");
		Element tbody = table.select("tbody").first();
		Elements tr = tbody.select("tr");
		tr.remove(0);
		for (int m = 0; m < tr.size(); m++) {
			Elements td = tr.get(m).select("td");
			if (td.size() == 9) {
				for (int n = 0; n < td.size(); n++) {
					text[n] = td.get(n).text();
				}
				String time = year+"/"+td.get(1).text();
				String latitude = td.get(2).text()+"°N";
				String longitude = td.get(3).text()+"°E";
				float mag = Float.parseFloat(td.get(4).text());
				String depth = td.get(5).text()+" Km";
				String placeName = td.get(6).text();
				sql = "insert into taiwan (place_name,longitude,latitude,mag,depth,time) values ('"+placeName+"','"+longitude+"','"+latitude+"',"+mag+",'"+depth+"','"+time+"')";
				conn.executeUpdate(sql);
			}
			System.out.println("\n第" + (m + 1) + "行数据：");
			System.out.print("[");
			for (String con : text) {
				System.out.print(con+",");
			}
			System.out.print("]");
		}
	}
}
