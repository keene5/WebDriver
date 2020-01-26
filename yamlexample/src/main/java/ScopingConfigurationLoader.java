/*
 * Copyright (c) 2018, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */



import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

/**
 * DNA Spring Boot Application for framework-rules-library.
 *
 * @author Pricing Team
 */
public class ScopingConfigurationLoader {

	private static final Logger LOGGER = Logger.getLogger(ScopingConfigurationLoader.class.getName());

	@Bean
	public ScopingConfiguration getScopingConfiguration(final InputStream inputStream) {
		try {
			return this.loadScopingConfiguration(inputStream);
		}
		finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			}
			catch (IOException e) {
				LOGGER.severe(e::getMessage);
			}
		}
	}

//	@Bean
//	@Deprecated
//	public RulesDocumentationConfiguration getRequirementConfiguration(final InputStream inputStream) {
//		try {
//			return this.loadRequirementConfiguration(inputStream);
//		}
//		finally {
//			try {
//				if (inputStream != null) {
//					inputStream.close();
//				}
//			}
//			catch (IOException e) {
//				LOGGER.severe(e::getMessage);
//			}
//		}
//	}

	private ScopingConfiguration loadScopingConfiguration(final InputStream scopingFile) {
		ScopingConfiguration scopingConfiguration;
		ScopingConfiguration scopingConfigurationDetails;
		ScopingObjectLoader scopingObjectLoader = new ScopingObjectLoader();

		try {
			scopingConfiguration = new ObjectMapper(new YAMLFactory()).readValue(scopingFile, ScopingConfiguration.class);
			scopingConfigurationDetails = scopingObjectLoader.createScopingDetailsObject(scopingConfiguration);
			scopingFile.close();
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
		return scopingConfigurationDetails;
	}

//	@Deprecated
//	private RulesDocumentationConfiguration loadRequirementConfiguration(final InputStream requirementsFile) {
//		RulesDocumentationConfiguration rulesDocumentationConfiguration;
//
//		try {
//			rulesDocumentationConfiguration = new ObjectMapper(new YAMLFactory()).readValue(requirementsFile, RulesDocumentationConfiguration.class);
//			requirementsFile.close();
//		}
//		catch (IOException e) {
//			throw new RuntimeException(e);
//		}
//		return rulesDocumentationConfiguration;
//	}
}
