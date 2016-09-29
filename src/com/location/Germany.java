package com.location;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.pojo.EarthQuake;
import com.util.DataBaseConnect;
import com.util.OperationEth;

public class Germany {
	public void content(String url) throws Exception {
		OperationEth operationEth = new OperationEth();
		Document doc = Jsoup.connect(url).timeout(10000).get();
		Element eqlist = doc.getElementById("eqlist");
		Element table = eqlist.select("table").first();
		Element tbody = table.select("tbody").first();
		Elements tr = tbody.select("tr");
		tr.remove(tr.size() - 1);
		tr.remove(0);
		tr.remove(0);
		for (int n = 0; n < tr.size(); n++) {
			EarthQuake earthQuake = new EarthQuake();
			Elements td = tr.get(n).select("td");
			
			String time = td.get(0).text();
			float mag = Float.parseFloat(td.get(1).text());
			String latitude = td.get(2).text();
			String longitude = td.get(3).text();
			String depth = td.get(4).text()+" km";
			String placeName = td.get(7).text();
			
			earthQuake.setPlaceName(placeName);
			earthQuake.setLongitude(longitude);
			earthQuake.setLatitude(latitude);
			earthQuake.setMag(mag);
			earthQuake.setDepth(depth);
			earthQuake.setTime(time);
			if(!operationEth.compare("germany", earthQuake)){
				operationEth.insert("germany", earthQuake);
			}
			operationEth.printEth((n+1),earthQuake);
		}
	}
}
