package com.location;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.pojo.EarthQuake;
import com.util.OperationEth;
import com.util.StringFormat;

public class Japan {
	public void content(String url) throws Exception {
		OperationEth operationEth = new OperationEth();
		StringFormat sf = new StringFormat();
		Document doc = Jsoup.connect(url).timeout(20000).get();
		Element info = doc.getElementById("info");
		Element table = info.select("table").first();
		Element tbody = table.select("tbody").first();
		Elements tr = tbody.select("tr");
		tr.remove(0);
		for (int n = 0; n < tr.size(); n++) {
			Elements td = tr.get(n).select("td");
			if (td.size() == 5) {
				String time = (Integer.parseInt(td.get(0).text().substring(2, 4))-28+2016) + "/"
						+ Integer.parseInt(td.get(0).text().substring(5, 7)) + "/" + Integer.parseInt(td.get(0).text().substring(8, 10)) + " "
						+ Integer.parseInt(td.get(0).text().substring(11, 13))+":"+Integer.parseInt(td.get(0).text().substring(14,16));
			String placeName = td.get(2).text();
			float mag = Float.parseFloat(sf.ToDBC(td.get(3).text().substring(1)));
			String depth = td.get(4).text().substring(2,3);
			String latitude = "";
			String longitude = "";
			EarthQuake earthQuake = new EarthQuake(placeName, latitude, longitude, mag, depth, time);
			if (!operationEth.compare("japan", earthQuake)) {
				operationEth.insert("japan", earthQuake);
			}
			operationEth.printEth((n + 1), earthQuake);
			}
		}
	}
}
