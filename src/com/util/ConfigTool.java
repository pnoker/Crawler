package com.util;

import java.util.Map;

public class ConfigTool {
	private String taiwan;
	private String america;
	private String japan;
	private String germany;
	private String switzerland;
	private String europe;

	public ConfigTool() {
		Map<String, String> config = null;
		try {
			config = ExcutePro.getP("config.properties");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		this.taiwan = config.get("taiwan");
		this.america = config.get("america");
		this.japan = config.get("japan");
		this.germany = config.get("germany");
		this.switzerland = config.get("switzerland");
		this.europe = config.get("europe");
	}

	public String getTaiwan() {
		return taiwan;
	}

	public void setTaiwan(String taiwan) {
		this.taiwan = taiwan;
	}

	public String getAmerica() {
		return america;
	}

	public void setAmerica(String america) {
		this.america = america;
	}

	public String getJapan() {
		return japan;
	}

	public void setJapan(String japan) {
		this.japan = japan;
	}

	public String getGermany() {
		return germany;
	}

	public void setGermany(String germany) {
		this.germany = germany;
	}

	public String getSwitzerland() {
		return switzerland;
	}

	public void setSwitzerland(String switzerland) {
		this.switzerland = switzerland;
	}

	public String getEurope() {
		return europe;
	}

	public void setEurope(String europe) {
		this.europe = europe;
	}

}
