package com.location;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.pojo.EarthQuake;
import com.util.OperationEth;
import com.util.Write;

public class America {
	public void content(String url) throws Exception {
		OperationEth operationEth = new OperationEth();
		Write write = new Write();
		Document doc2 = Jsoup.connect(url).timeout(20000).get();
		Elements entry = doc2.select("entry");
		for (int n = 0; n < entry.size(); n++) {
			String title = entry.get(n).select("title").text();
			String placeName = title.substring(title.indexOf("-") + 2);
			float mag = Float.parseFloat(title.split(" ")[1]);
			Element summary = entry.get(n).select("summary").first();
			Document html = Jsoup.parse(summary.text());
			Elements dd = html.select("dd");
			String time = dd.get(0).text().substring(0, dd.get(0).text().indexOf("UTC") - 1);
			String longitude = dd.get(2).text().split(" ")[1];
			String latitude = dd.get(2).text().split(" ")[0];
			String depth = dd.get(3).text();
			EarthQuake earthQuake = new EarthQuake(placeName, latitude, longitude, mag, depth, time);
			if (!operationEth.compare("america", earthQuake)) {
				operationEth.insert("america", earthQuake);
				write.write("america", earthQuake);
			}
			operationEth.printEth((n + 1), earthQuake);
		}
	}
}
