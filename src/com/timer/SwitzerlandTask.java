package com.timer;

import java.util.TimerTask;

import com.location.Switzerland;
import com.util.ReadConfig;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年9月30日
 * @description
 */

public class SwitzerlandTask extends TimerTask {
	@Override
	public void run() {
		Switzerland switzerland = new Switzerland();
		ReadConfig url = new ReadConfig();
		System.out.print("\n********瑞士**********\n");
		try {
			switzerland.content(url.getSwitzerland());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
