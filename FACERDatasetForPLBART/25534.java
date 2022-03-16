	/**
	 * Gets the artist name to display for a given song.
	 * @param songFile
	 * @param musicRoot
	 * @return
	 */
	static String getArtistName(File songFile, String musicRoot) {
		File albumDir = songFile.getParentFile().getParentFile();
		if (albumDir.getAbsolutePath().equals(musicRoot)) {
			return songFile.getParentFile().getName();
		}
		return songFile.getParentFile().getParentFile().getName();
	}

