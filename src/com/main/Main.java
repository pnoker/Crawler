package com.main;

import com.location.America;
import com.location.Europe;
import com.location.Germany;
import com.location.Japan;
import com.location.Switzerland;
import com.location.TaiWan;
import com.util.ReadConfig;

public class Main {
	public static void main(String[] args) throws Exception {
		ReadConfig url = new ReadConfig();
		Japan japan = new Japan();
		TaiWan taiwan = new TaiWan();
		Germany germany = new Germany();
		America america = new America();
		Switzerland switzerland = new Switzerland();
		Europe europe = new Europe();
//		System.out.print("********美国**********\n");
//		america.content(url.getAmerica());
//		System.out.print("\n\n********欧洲**********\n");
//		europe.content(url.getEurope());
//		System.out.print("\n\n********瑞士**********\n");
//		switzerland.content(url.getSwitzerland());
		System.out.print("\n\n********德国**********\n");
		germany.content(url.getGermany());
//		System.out.print("\n\n********台湾**********\n");
//		taiwan.content(url.getTaiwan());
//		System.out.print("\n\n********日本**********\n");
//		japan.content(url.getJapan());
	}
}
