package com.location;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.util.DataBaseConnect;

public class Switzerland {
	public void content(String url) throws Exception {
		DataBaseConnect conn = new DataBaseConnect();
		String sql = "";
		String[] text = new String[10];
		Document doc2 = Jsoup.connect(url).timeout(20000).get();
		Element table = doc2.getElementsByClass("eq_list").first();
		Element tbody = table.select("tbody").first();
		Elements tr = tbody.select("tr");
		tr.remove(0);
		for (int m = 0; m < tr.size(); m++) {
			Elements td = tr.get(m).select("td");
			if (td.size() == 10) {
				for (int n = 0; n < td.size(); n++) {
					text[n] = td.get(n).text();
				}
				String time = td.get(0).text()+" "+td.get(1).text();
				String latitude = "";
				String longitude = "";
				if(Float.parseFloat(td.get(2).text())>0){
					latitude = Float.parseFloat(td.get(2).text())+"°N";
				}else{
					latitude = (Float.parseFloat(td.get(2).text())*(-1))+"°S";
				}
				if(Float.parseFloat(td.get(3).text())>0){
					longitude = Float.parseFloat(td.get(2).text())+"°E";
				}else{
					longitude = (Float.parseFloat(td.get(3).text())*(-1))+"°W";
				}
				String depth = td.get(4).text()+" Km";
				float mag = Float.parseFloat(td.get(6).text());
				String placeName = td.get(9).text();
				sql = "insert into switzerland (place_name,longitude,latitude,mag,depth,time) values ('"+placeName+"','"+longitude+"','"+latitude+"',"+mag+",'"+depth+"','"+time+"')";
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
