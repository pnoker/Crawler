package com.location;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Europe {
	public void content(String url) throws Exception {
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
