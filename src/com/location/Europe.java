package com.location;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.util.DataBaseConnect;

public class Europe {
	public void content(String url) throws Exception {
		DataBaseConnect conn = new DataBaseConnect();
		String sql = "";
		String[] text = new String[13];
		Document doc2 = Jsoup.connect(url).timeout(10000).get();
		Element tbody = doc2.getElementById("tbody");
		Elements tr = tbody.select("tr");
		for (int n = 0; n < tr.size(); n++) {
			Elements td = tr.get(n).select("td");
			if (td.size() == 13) {
				for (int m = 0; m < td.size(); m++) {
					text[m] = td.get(m).text();
				}
				String time = td.get(3).select("a").first().text().substring(0, 10)+" "+td.get(3).select("a").first().text().substring(13);
				String latitude = td.get(4).text().substring(0, 5)+"°"+td.get(5).text().substring(0, 1);
				String longitude = td.get(6).text().substring(0, 5)+"°"+td.get(7).text().substring(0, 1);
				String depth = td.get(8).text()+" Km";
				float mag = Float.parseFloat(td.get(10).text());
				String placeName = td.get(11).text();
				sql = "insert into europe (place_name,longitude,latitude,mag,depth,time) values ('"+placeName+"','"+longitude+"','"+latitude+"',"+mag+",'"+depth+"','"+time+"')";
				conn.executeUpdate(sql);
			}
			System.out.println("\n第" + (n + 1) + "行数据：");
			System.out.print("[");
			for (String con : text) {
				System.out.print(con+",");
			}
			System.out.print("]");
		}
	}
}
