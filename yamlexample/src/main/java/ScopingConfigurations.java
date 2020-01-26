/*
 * Copyright (c) 2018, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */


import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Configuration that holds all of the scoping information for this application.
 *
 * For reasons why we're ignoring the PMD/Checkstyle warnings, please see the following:
 * https://www.javacodegeeks.com/2014/08/javas-volatile-modifier-2.html
 * https://en.wikipedia.org/wiki/Double-checked_locking
 * http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html (see Under the new Java Memory Model)
 */
@Component
@SuppressWarnings({"PMD.AvoidUsingVolatile", "PMD.NonThreadSafeSingleton"})
public final class ScopingConfigurations {

	private static volatile Map<String, ScopingConfiguration> scopingConfigurationMap;
	private static volatile long mapInitializationCount;

	private ScopingConfigurations() {
	}

	public static ScopingConfiguration getInstance(String scopingConfigurationKey) {
		Map<String, ScopingConfiguration> localMap = scopingConfigurationMap;
		if (null == localMap) {
			synchronized (ScopingConfigurations.class) {
				if (null == localMap) {
					mapInitializationCount++;
					ScopingConfigurationLoader scopingConfigurationLoader = new ScopingConfigurationLoader();
					scopingConfigurationMap = localMap = new HashMap<>();
					scopingConfigurationMap.put(Constants.TWO_VEHICLES, scopingConfigurationLoader.
						getScopingConfiguration(getConfigResourceStream(Constants.TWO_VEHICLE_FILENAME)));

				}
			}
		}
		return localMap.get(scopingConfigurationKey);
	}

//	@Deprecated
//	public static List<RulesDocumentationConfiguration> getRulesDocumentationInstance() {
//		throw new NotImplementedException();
//	}
//
//	public static long getMapInitializationCount() {
//		return mapInitializationCount;
//	}

	private static InputStream getConfigResourceStream(final String configFile) {
		return ScopingConfigurations.class.getResourceAsStream(configFile);
	}
}
