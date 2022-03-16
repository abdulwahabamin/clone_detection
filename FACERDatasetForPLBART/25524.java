	/**
	 * Checks whether the provided directory is a legal artist directory.
	 * @param dir
	 * @return
	 */
	static boolean isValidArtistDirectory(File dir) {
		if (dir == null) {
			return false;
		}

		if (!dir.isDirectory()) {
			return false;
		}

		return true;
	}

