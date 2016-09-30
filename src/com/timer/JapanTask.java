package com.timer;

import java.util.TimerTask;

import com.location.Japan;
import com.util.ReadConfig;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年9月30日
 * @description
 */

public class JapanTask extends TimerTask {
	@Override
	public void run() {
		Japan japan = new Japan();
		ReadConfig url = new ReadConfig();
		System.out.print("\n********日本**********\n");
		try {
			japan.content(url.getJapan());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
