	/**
	 * Method to open given dir
	 *
	 * @param dir
	 * @return
	 */
	public List<String> openDir(String dir) {
		if (isExists(currentDir + "/" + dir)) {
			previousDir = currentDir;
			currentDir = currentDir + "/" + dir;
			return listFiles();
		} else
			return null;
	}

