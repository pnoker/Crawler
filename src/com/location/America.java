package com.location;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class America {
	public void content(String url) throws Exception {
		Document doc2 = Jsoup.connect(url).timeout(10000).get();
		Elements entry = doc2.select("entry");
		for (int m = 0; m < entry.size(); m++) {
			String title = entry.get(m).select("title").text();
			String updated = entry.get(m).select("updated").text();
			Element summary = entry.get(m).select("summary").first();
			Document html = Jsoup.parse(summary.text());
			Elements dd = html.select("dd");
			System.out.println("\n第" + (m+1) + "行数据：");
			System.out.print("[");
			System.out.print(title+",");
			System.out.print(updated+",");
			System.out.print(dd.get(0).text()+",");
			System.out.print(dd.get(2).text()+",");
			System.out.print(dd.get(3).text());
			System.out.print("]");
		}
	}
}
