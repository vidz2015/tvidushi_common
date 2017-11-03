package com.spacetimeinsight.admin.server.util;

import java.util.Properties;

import com.enterprisehorizons.util.PropertyFilesFactory;

public final class PropertyFileUtils implements IPropertyFileConstants {

	public static Properties getDatasourceProperties() {
		return PropertyFilesFactory.getInstance().getProperties(DATASOURCE_APPLICATION_RESOURCES);
	}
	
	public static Properties getEcoWebProperties() {
		return PropertyFilesFactory.getInstance().getProperties(ECOWEB_APPLICATION_RESOURCES);
	}
}
