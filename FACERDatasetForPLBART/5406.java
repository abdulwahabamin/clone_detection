	/**
	 * Method that return openable intent according to the file type
	 *
	 * @param file
	 * @return
	 */

	public Intent getOpenableIntent(String file) {
		return getAbsoluteOpenableIntent(currentDir+"/"+file);
	}

