package com.location;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.util.DataBaseConnect;
import com.util.StringFormat;

public class Japan {
	public void content(String url) throws Exception {
		DataBaseConnect conn = new DataBaseConnect();
		String sql = "";
		StringFormat sf = new StringFormat();
		String[] text = new String[5];
		Document doc2 = Jsoup.connect(url).timeout(20000).get();
		Element info = doc2.getElementById("info");
		Element table = info.select("table").first();
		Element tbody = table.select("tbody").first();
		Elements tr = tbody.select("tr");
		tr.remove(0);
		for (int m = 0; m < tr.size(); m++) {
			Elements td = tr.get(m).select("td");
			if (td.size() == 5) {
				for (int n = 0; n < td.size(); n++) {
					text[n] = td.get(n).text();
				}
				String time = (Integer.parseInt(td.get(0).text().substring(2, 4))-28+2016) + "/"
						+ Integer.parseInt(td.get(0).text().substring(5, 7)) + "/" + Integer.parseInt(td.get(0).text().substring(8, 10)) + " "
						+ Integer.parseInt(td.get(0).text().substring(11, 13))+":"+Integer.parseInt(td.get(0).text().substring(14,16));
			String placeName = td.get(2).text();
			float mag = Float.parseFloat(sf.ToDBC(td.get(3).text().substring(1)));
			String depth = td.get(4).text().substring(2,3);
			String latitude = "";
			String longitude = "";
			sql = "insert into japan (place_name,longitude,latitude,mag,depth,time) values ('"+placeName+"','"+longitude+"','"+latitude+"',"+mag+",'"+depth+"','"+time+"')";
			conn.executeUpdate(sql);
			}
			System.out.println("\n第" + (m + 1) + "行数据：");
			System.out.print("[");
			for (String con : text) {
				System.out.print(con + ",");
			}
			System.out.print("]");
		}
	}
}
