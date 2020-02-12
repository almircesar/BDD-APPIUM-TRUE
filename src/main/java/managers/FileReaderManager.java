package managers;

import dataProviders.Config;

public class FileReaderManager {

	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static Config config;

	private FileReaderManager() {
	}

	public static FileReaderManager getInstance() {
		return fileReaderManager;
	}

	public Config getConfigReader() {
		return (config == null) ? new Config() : config;
	}
	
	
}