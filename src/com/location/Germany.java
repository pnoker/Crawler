package com.location;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Germany {
	public void content(String url) throws Exception {
		String[] text = new String[8];
		Document doc2 = Jsoup.connect(url).timeout(10000).get();
		Element eqlist = doc2.getElementById("eqlist");
		Element table = eqlist.select("table").first();
		Element tbody = table.select("tbody").first();
		Elements tr = tbody.select("tr");
		tr.remove(tr.size() - 1);
		tr.remove(0);
		tr.remove(0);
		for (int n = 0; n < tr.size(); n++) {
			Elements td = tr.get(n).select("td");
			for (int i = 0; i < 8; i++) {
				text[i] = td.get(i).text();
			}
			System.out.println("\n第" + (n+1) + "行数据：");
			System.out.print("[");
			for (String con : text) {
				System.out.print(con+",");
			}
			System.out.print("]");
		}
	}
}
