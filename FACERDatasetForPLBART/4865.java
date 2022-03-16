	public static FileCreateTask newVideoFile() {
		StringBuilder dir = new StringBuilder(HOME_PATH_FILES);
		dir.append(File.separator);
		dir.append(FOLDER_VIDEO);

		FileCreateTask f = new FileCreateTask(dir.toString(),newFileName(FILE_EXT_VIDEO_MP4));

		return f;
	}

