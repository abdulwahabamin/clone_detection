	/**
	 * Checks whether this file is a song.
	 * @param song
	 * @return True if the song ends with a music file extension and is not hidden.
	 */
	static boolean isValidSongFile(File song) {
		if (song == null) {
			return false;
		}

		if (!song.isFile()) {
			return false;
		}

		if(song.isHidden()){
			return false;
		}

		String name = song.getName();
		String extension = getFileExtension(name);

		return MediaTypeUtils.hasExtension(extension);
	}

