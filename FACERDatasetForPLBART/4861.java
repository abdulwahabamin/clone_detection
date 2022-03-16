	public static FileCreateTask newTwitterImageFile() {
		StringBuilder dir = new StringBuilder(HOME_PATH_FILES);
		dir.append(File.separator);
		dir.append(FOLDER_TWITTER_IMAGES);

		FileCreateTask f = new FileCreateTask(dir.toString(),newFileName(FILE_EXT_JPG));

		return f;
	}

