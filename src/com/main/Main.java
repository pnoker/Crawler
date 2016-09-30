package com.main;

import java.util.Timer;

import com.timer.AmericaTask;
import com.timer.EuropeTask;
import com.timer.GermanyTask;
import com.timer.JapanTask;
import com.timer.SwitzerlandTask;
import com.timer.TaiwanTask;

public class Main {
	public static void main(String[] args) throws Exception {
		Timer timer = new Timer();
		timer.schedule(new AmericaTask(), 1000, 60 * 60 * 1000);
		timer.schedule(new EuropeTask(), 1000, 60 * 60 * 1000);
		timer.schedule(new GermanyTask(), 1000, 60 * 60 * 1000);
		timer.schedule(new JapanTask(), 1000, 60 * 60 * 1000);
		timer.schedule(new SwitzerlandTask(), 1000, 60 * 60 * 1000);
		timer.schedule(new TaiwanTask(), 1000, 60 * 60 * 1000);
	}
}
