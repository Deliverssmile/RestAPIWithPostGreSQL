package com.deliverssmille.ahirsmile.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"sanjay"})
public class ConfigPropsValues {
	
	@Value("${mongodburl}")
	private String mongoDbUrl;
	
	@Value("${mongodbname}")
	private String mongoDbName;

}
