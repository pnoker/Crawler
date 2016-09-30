package com.timer;

import java.util.TimerTask;

import com.location.America;
import com.util.ReadConfig;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年9月30日
 * @description
 */

public class AmericaTask extends TimerTask {
	@Override
	public void run() {
		America america = new America();
		ReadConfig url = new ReadConfig();
		System.out.print("\n********美国**********\n");
		try {
			america.content(url.getAmerica());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
