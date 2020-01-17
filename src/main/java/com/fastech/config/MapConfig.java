package com.fastech.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;

import com.fastech.config.mapconfig.Intermap;
import com.fastech.config.mapconfig.MapImpl1;
import com.fastech.config.mapconfig.MapImpl2;

@Configuration
public class MapConfig {
	public static Map<String, Intermap> mapconfig;

	public MapConfig() {
		mapconfig = new HashMap<>();
		mapconfig.put("1", new MapImpl1());
		mapconfig.put("2", new MapImpl2());
	}

}
