package com.timer;

import java.util.TimerTask;

import com.location.TaiWan;
import com.util.ReadConfig;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年9月30日
 * @description
 */

public class TaiwanTask extends TimerTask {
	@Override
	public void run() {
		TaiWan taiwan = new TaiWan();
		ReadConfig url = new ReadConfig();
		System.out.print("\n********台湾**********\n");
		try {
			taiwan.content(url.getTaiwan());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
