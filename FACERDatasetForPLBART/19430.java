	public String getRelativePath(String playlistFilePath, String songFilePath) {
		
		String relativePath = RelativizePaths.convertToRelativePath(playlistFilePath, songFilePath);
		return relativePath;
		
	}

