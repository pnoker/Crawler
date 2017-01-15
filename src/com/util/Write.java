package com.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import com.pojo.EarthQuake;

/**
 * @author Pnoker
 *
 */
public class Write {
	private String path;
	private ProEntry proEntry = new ProEntry();

	public Write() {
		ReadConfig data = new ReadConfig();// 读取配置文件
		String osName = System.getProperties().getProperty("os.name");// 获取当前系统的名称
		if (osName.toLowerCase().startsWith("win")) {
			this.path = data.getWinPath();
		} else {
			this.path = data.getLinuxPath();
		}

		if (!(new File(this.path).isDirectory())) {// 如果没有该路径就创建
			new File(this.path).mkdirs();
		}
	}

	public void write(String name, EarthQuake earthQuake) throws Exception {

		String time = proEntry.proTime(earthQuake.getTime());
		String longitude = proEntry.proLongitude(earthQuake.getLongitude());
		String latitude = proEntry.proLatitude(earthQuake.getLatitude());
		String depth = proEntry.proDepth(earthQuake.getDepth());
		String mag = proEntry.proMag(earthQuake.getMag());

		String file = path + name + ".txt";
		try {
			FileOutputStream fos = new FileOutputStream(file, true);
			BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8"));
			fw.write("send2eqim.x " + time + " " + longitude + " " + latitude + " " + depth + " " + mag + " " + name);
			fw.newLine();
			fw.flush();
			fw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
