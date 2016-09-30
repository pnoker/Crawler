package com.timer;

import java.util.TimerTask;

import com.location.Germany;
import com.util.ReadConfig;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年9月30日
 * @description
 */

public class GermanyTask extends TimerTask {
	@Override
	public void run() {
		Germany germany = new Germany();
		ReadConfig url = new ReadConfig();
		System.out.print("\n********德国**********\n");
		try {
			germany.content(url.getGermany());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
