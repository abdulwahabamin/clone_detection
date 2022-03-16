	/**
	 * Get all directories which contain music files
	 * @param directory
	 * @return
	 */
	static List<File> getAllAlbumsInDirRecursive(File directory){
		List<File> albums = new ArrayList<>();
		_getAllAlbumsInDirRecurive(directory, albums);
		return albums;
	}

