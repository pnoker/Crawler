package com.location;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TaiWan {
	public void content(String url) throws Exception {
		String[] text = new String[9];
		Document doc2 = Jsoup.connect(url).timeout(10000).get();
		Element table = doc2.getElementById("gvEvent");
		Element tbody = table.select("tbody").first();
		Elements tr = tbody.select("tr");
		tr.remove(0);
		for (int m = 0; m < tr.size(); m++) {
			Elements td = tr.get(m).select("td");
			if (td.size() == 9) {
				for (int n = 0; n < td.size(); n++) {
					text[n] = td.get(n).text();
				}
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
