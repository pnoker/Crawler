package com.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test {
	static String url = "http://www.jma.go.jp/jp/quake/quake_local_index.html";

	public static void main(String[] args) throws Exception {
		BolgBody();
	}

	private static void BolgBody() throws IOException {
		
//		String html = http();
//		Document doc = Jsoup.parse(html);
//		Element tbody = doc.select("table").first();
//		System.out.println(tbody);
		
		
		String[] text = new String[5];
		Document doc2 = Jsoup.connect(url).timeout(5000).get();
		Element info = doc2.getElementById("info");
		Element table = info.select("table").first();
		Element tbody = table.select("tbody").first();
		Elements tr = tbody.select("tr");
		tr.remove(0);
		for(int m = 0;m<tr.size();m++){
		Elements td = tr.get(m).select("td");
		if(td.size()==5){
			for(int n=0;n<td.size();n++){
			 text[n] = td.get(n).text();
			 }
		}
		System.out.println("\n第"+(m+1)+"行数据：");
		 for(String con:text){
		 System.out.println(con);
		 }
	}
		
		
		
//		Element table = doc2.getElementById("gvEvent");
//		Element tbody = table.select("tbody").first();
//		Elements tr = tbody.select("tr");
//		tr.remove(0);
//		for(int m = 0;m<tr.size();m++){
//			Elements td = tr.get(m).select("td");
//			if(td.size()==9){
//				for(int n=0;n<td.size();n++){
//					 text[n] = td.get(n).text();
//					 }
//			}
//			System.out.println("\n第"+(m+1)+"行数据：");
//			 for(String con:text){
//			 System.out.println(con);
//			 }
//		}

		
		
		
		// Elements tr = tbody.select("tr");
		// for(int n=0;n<tr.size();n++){
		// Elements td = tr.get(n).select("td");
		// if(td.size()==13){
		// for(int m=0;m<td.size();m++){
		// text[m] = td.get(m).text();
		// }
		// }
		// System.out.println("\n第"+(n+1)+"行数据：");
		// for(String con:text){
		// System.out.println(con);
		// }
		// }
		// for (int n = 0; n < tr.size(); n++) {
		// Elements td = tr.get(n).select("td");
		// for (int i = 0; i < 8; i++) {
		// text[i] = td.get(i).text();
		// }
		// System.out.println("\n第"+(n+1)+"行数据：");
		// for (String con : text) {
		// System.out.println(con);
		// }
		// }
	}

	public static void article() {
		Document doc;
		try {
			doc = Jsoup.connect("http://www.cnblogs.com/zyw-205520/").get();
			Elements ListDiv = doc.getElementsByAttributeValue("class", "postTitle");
			for (Element element : ListDiv) {
				Elements links = element.getElementsByTag("a");
				for (Element link : links) {
					String linkHref = link.attr("href");
					String linkText = link.text().trim();
					System.out.println(linkHref);
					System.out.println(linkText);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 获取指定博客文章的内容
	 */
	public static void Blog() {
		Document doc;
		try {
			doc = Jsoup.connect("http://www.cnblogs.com/zyw-205520/archive/2012/12/20/2826402.html").get();
			Elements ListDiv = doc.getElementsByAttributeValue("class", "postBody");
			for (Element element : ListDiv) {
				System.out.println(element.html());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String http() {
		String html = "";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost("http://www.seismo.ethz.ch/eq/latest?list=w");
		try {
			System.out.println("executing request " + httppost.getURI());
			CloseableHttpResponse response = httpclient.execute(httppost);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					System.out.println("Response content: " + EntityUtils.toString(entity, "UTF-8"));
					html = EntityUtils.toString(entity, "UTF-8");
				}
				return url;
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return html;

	}

}