	/**
	 * Method to check whether the given path exist or not
	 *
	 * @param dir
	 * @return
	 */

	public boolean isExists(String dir) {

		if (dir == null)
			return false;
		try {
			return new File(dir).exists();
		} catch (NullPointerException e) {
			return false;
		}

	}

