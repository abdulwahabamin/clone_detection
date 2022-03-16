	/**
	 * Method to go up from current directory
	 *
	 * @return
	 */

	public boolean goUp() {
		if (previousDir == null)
			return false;
		if (currentDir.equals(defaultDir))
			return false;
		currentDir = previousDir;

		try {
			tempDir = new File(previousDir).getParent();

		} catch (NullPointerException e) {
			Log.d(TAG, "You are already at root directory.");
			return false;
		}

		if (isExists(tempDir)) {
			previousDir = tempDir;
		} else
			previousDir = null;

		return true;
	}

