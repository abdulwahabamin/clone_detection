	/**
	 * Method to set current directory
	 *
	 * @param dir
	 * @return
	 */

	public boolean setCurrentDir(String dir) {
		if (isExists(dir)) {
			currentDir = dir;

			try {
				previousDir = new File(dir).getParent();
			} catch (NullPointerException e) {
				Log.e(TAG, "There is no parent for current directory.");
				return false;
			}
			return true;
		}
		return false;
	}

