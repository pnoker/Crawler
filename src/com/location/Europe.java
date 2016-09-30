package com.location;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.pojo.EarthQuake;
import com.util.OperationEth;

public class Europe {
	public void content(String url) throws Exception {
		OperationEth operationEth = new OperationEth();
		Document doc2 = Jsoup.connect(url).timeout(20000).get();
		Element tbody = doc2.getElementById("tbody");
		Elements tr = tbody.select("tr");
		for (int n = 0; n < tr.size(); n++) {
			Elements td = tr.get(n).select("td");
			if (td.size() == 13) {
				String time = td.get(3).select("a").first().text().substring(0, 10) + " "
						+ td.get(3).select("a").first().text().substring(13);
				String latitude = td.get(4).text().substring(0, 5) + "°" + td.get(5).text().substring(0, 1);
				String longitude = td.get(6).text().substring(0, 5) + "°" + td.get(7).text().substring(0, 1);
				String depth = td.get(8).text() + " Km";
				float mag = Float.parseFloat(td.get(10).text());
				String placeName = td.get(11).text();
				EarthQuake earthQuake = new EarthQuake(placeName, latitude, longitude, mag, depth, time);
				if (!operationEth.compare("europe", earthQuake)) {
					operationEth.insert("europe", earthQuake);
				}
				operationEth.printEth((n + 1), earthQuake);
			}
		}
	}
}
