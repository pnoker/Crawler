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

import com.util.StringFormat;

public class Test {
	static String url = "http://www.jma.go.jp/jp/quake/20160930050604495-300502.html";

	public static void main(String[] args) throws Exception {
		BolgBody();
	}
	
	public static String ToDBC(String input) {
        

        char c[] = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
          if (c[i] == '\u3000') {
            c[i] = ' ';
          } else if (c[i] > '\uFF00' && c[i] < '\uFF5F') {
            c[i] = (char) (c[i] - 65248);

          }
        }
   String returnString = new String(c);
   
        return returnString;
}

	private static void BolgBody() throws IOException {
		Document doc2 = Jsoup.connect(url).timeout(5000).get();
		Element table = doc2.getElementById("infobox");
		Element td = table.select("td").first();
		Element br =  td.select("br").first();
		StringFormat sf = new StringFormat();
		String bw = sf.ToDBC(td.text()).substring(sf.ToDBC(td.text()).indexOf("("),sf.ToDBC(td.text()).indexOf(")")+1);
		String wei = bw.substring(bw.indexOf("(北緯")+3,bw.indexOf("度、東経"));
		String jing = bw.substring(bw.indexOf("度、東経")+4,bw.indexOf("度)"));
		String depth = sf.ToDBC(td.text()).substring(sf.ToDBC(td.text()).indexOf("震源の深さは約")+7,sf.ToDBC(td.text()).indexOf("km"));
		System.out.println(sf.ToDBC(td.text()));
		System.out.println(bw);
		System.out.println(wei);
		System.out.println(jing);
		System.out.println(depth);
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