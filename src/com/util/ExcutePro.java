package com.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class ExcutePro {

	// 读取.properties 结尾的配置文件用，getP, getParam
	public static Map<String, String> getP(String path) throws Exception {
		Resource resource = new ClassPathResource(path);
		Properties props = PropertiesLoaderUtils.loadProperties(resource);
		Map<String, String> param = new HashMap<String, String>((Map) props);
		return param;
	}

}