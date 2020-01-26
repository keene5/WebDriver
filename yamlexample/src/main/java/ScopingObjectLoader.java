/*
 * Copyright (c) 2018, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */


/**
 * DNA Spring Boot Application for ScopingObjectLoader.
 *
 * @author Pricing Team
 */

@SuppressWarnings({"HideUtilityClassConstructor", "PMD.AvoidInstantiatingObjectsInLoops", "PMD.UseUtilityClass"})
public class ScopingObjectLoader {

	public static ScopingConfiguration createScopingDetailsObject(ScopingConfiguration scopingConfiguration) {
		String programName = scopingConfiguration.getProgramName();


		scopingConfiguration.setProgramName(programName);

		return scopingConfiguration;
	}
}
