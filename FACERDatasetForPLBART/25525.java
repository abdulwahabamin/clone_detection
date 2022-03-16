	/**
	 * Checks whether the provided directory is a legal album directory.
	 * @param dir
	 * @return
	 */
	static boolean isValidAlbumDirectory(File dir) {
		if (dir == null) {
			return false;
		}

		if (!dir.isDirectory()) {
			return false;
		}

		return true;
	}

