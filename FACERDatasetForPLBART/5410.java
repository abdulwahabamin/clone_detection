	/**
	 * @param file
	 * @return
	 */
	public String getFileSize(String file) {
		String completePath=currentDir + "/" + file;
		return getAbsoluteFileSize(completePath);
	}

