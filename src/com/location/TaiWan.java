package com.location;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.pojo.EarthQuake;
import com.util.OperationEth;

public class TaiWan {

	public void content(String url) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String year = sdf.format(new Date());
		OperationEth operationEth = new OperationEth();
		Document doc2 = Jsoup.connect(url).timeout(20000).get();
		Element table = doc2.getElementById("gvEvent");
		Element tbody = table.select("tbody").first();
		Elements tr = tbody.select("tr");
		tr.remove(0);
		for (int n = 0; n < tr.size(); n++) {
			Elements td = tr.get(n).select("td");
			if (td.size() == 9) {
				String time = year + "/" + td.get(1).text();
				String latitude = td.get(2).text() + "°N";
				String longitude = td.get(3).text() + "°E";
				float mag = Float.parseFloat(td.get(4).text());
				String depth = td.get(5).text() + " Km";
				String placeName = td.get(6).text();
				EarthQuake earthQuake = new EarthQuake(placeName, latitude, longitude, mag, depth, time);
				if (!operationEth.compare("taiwan", earthQuake)) {
					operationEth.insert("taiwan", earthQuake);
				}
				operationEth.printEth((n + 1), earthQuake);
			}
		}
	}
}
