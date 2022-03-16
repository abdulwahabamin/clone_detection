	/**
	 * Method to change root directory.
	 *
	 * @param dir
	 * @return
	 */
	public boolean changeRootDirectory(String dir) {
		if (!isExists(dir))
			return false;
		defaultDir = dir;
		currentDir=dir;
		return true;
	}

