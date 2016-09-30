package com.timer;

import java.util.TimerTask;

import com.location.Europe;
import com.util.ReadConfig;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年9月30日
 * @description
 */

public class EuropeTask extends TimerTask {
	@Override
	public void run() {
		Europe europe = new Europe();
		ReadConfig url = new ReadConfig();
		System.out.print("\n********欧洲**********\n");
		try {
			europe.content(url.getEurope());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
