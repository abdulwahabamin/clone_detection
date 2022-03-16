	/**
	 * Method to create FileEx Instance
	 *
	 * @param dir
	 * @return FileEx
	 */

	public static synchronized FileEx newFileManager(String dir, Context c) {

		if (fileEx == null) {
			fileEx = new FileEx(dir);
			currentDir = dir;
			previousDir = null;
			context = c;
		}
		return fileEx;
	}

