	public static FileCreateTask newImageFileJpg(String filename) {
		StringBuilder dir = new StringBuilder(HOME_PATH_FILES);
		dir.append(File.separator);
		dir.append(FOLDER_IMAGES);

		FileCreateTask f = new FileCreateTask(dir.toString(),filename);

		return f;
	}

