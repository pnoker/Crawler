package com.location;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.pojo.EarthQuake;
import com.util.OperationEth;
import com.util.Write;

public class Switzerland {
	public void content(String url) throws Exception {
		OperationEth operationEth = new OperationEth();
		Write write = new Write();
		Document doc2 = Jsoup.connect(url).timeout(30000).get();
		Element table = doc2.getElementsByClass("eq_list").first();
		Element tbody = table.select("tbody").first();
		Elements tr = tbody.select("tr");
		tr.remove(0);
		for (int n = 0; n < tr.size(); n++) {
			Elements td = tr.get(n).select("td");
			if (td.size() == 10) {
				String time = td.get(0).text()+" "+td.get(1).text();
				String latitude = "";
				String longitude = "";
				if(Float.parseFloat(td.get(2).text())>0){
					latitude = Float.parseFloat(td.get(2).text())+"°N";
				}else{
					latitude = (Float.parseFloat(td.get(2).text())*(-1))+"°S";
				}
				if(Float.parseFloat(td.get(3).text())>0){
					longitude = Float.parseFloat(td.get(3).text())+"°E";
				}else{
					longitude = (Float.parseFloat(td.get(3).text())*(-1))+"°W";
				}
				String depth = td.get(4).text()+" Km";
				float mag = Float.parseFloat(td.get(6).text());
				String placeName = td.get(9).text();
				EarthQuake earthQuake = new EarthQuake(placeName, latitude, longitude, mag, depth, time);
				if (!operationEth.compare("switzerland", earthQuake)) {
					operationEth.insert("switzerland", earthQuake);
					write.write("switzerland", earthQuake);
				}
				operationEth.printEth((n + 1), earthQuake);
			}
		}
	}
}
