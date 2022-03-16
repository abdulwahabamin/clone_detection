	/**
	 * Populates the currentFileList with all the files/folders in the current
	 * directory
	 */
	public void populateFiles() {
		// Clear current file list for updating
		currentFileList.clear();
		// Create a file from the current path
		File current = new File(path);
		// Array of the files within the current directory
		File[] subFiles = current.listFiles();
		// Add each filepath in the current directory to currentFileList
		for (int i = 0; i < subFiles.length; i++) {
			currentFileList.add(subFiles[i].getPath());
		}
	}

