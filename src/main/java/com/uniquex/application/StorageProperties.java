package com.uniquex.application;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageProperties {

	/**
	 * Folder location for storing files
	 */
	private String location = "upload-dir";

	private String ruggeroLocation = "ruggero-dir";

	private String sortedStudentFileLocation = "output-files";

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {

		this.location = location;

	}

	public String getRuggeroLocation() {
		return ruggeroLocation;
	}

	public void setRuggeroLocation(String ruggeroLocation) {
		this.ruggeroLocation = ruggeroLocation;
	}

	public String getSortedStudentFileLocation() {
		return sortedStudentFileLocation;
	}
}
