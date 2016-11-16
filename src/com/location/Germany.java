package com.location;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.pojo.EarthQuake;
import com.util.OperationEth;
import com.util.Write;

public class Germany {
	public void content(String url) throws Exception {
		OperationEth operationEth = new OperationEth();
		Write write = new Write();
		Document doc = Jsoup.connect(url).timeout(20000).get();
		Element eqlist = doc.getElementById("eqlist");
		Element table = eqlist.select("table").first();
		Element tbody = table.select("tbody").first();
		Elements tr = tbody.select("tr");
		tr.remove(tr.size() - 1);
		tr.remove(0);
		tr.remove(0);
		for (int n = 0; n < tr.size(); n++) {
			Elements td = tr.get(n).select("td");
			String time = td.get(0).text();
			float mag = Float.parseFloat(td.get(1).text());
			String latitude = td.get(2).text();
			String longitude = td.get(3).text();
			String depth = td.get(4).text() + " km";
			String placeName = td.get(7).text();
			EarthQuake earthQuake = new EarthQuake(placeName, latitude, longitude, mag, depth, time);
			if (!operationEth.compare("germany", earthQuake)) {
				operationEth.insert("germany", earthQuake);
				write.write("germany", earthQuake);
			}
			operationEth.printEth((n + 1), earthQuake);
		}
	}
}
