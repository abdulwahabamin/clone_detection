	/**
	 * Method to check whether the given path is file or dir
	 *
	 * @param name
	 * @return
	 */

	public boolean isFile(String name) {
		if (new File(currentDir + "/" + name).isFile())
			return true;
		return false;
	}

