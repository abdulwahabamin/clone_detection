	public static FileCreateTask newImageFileBmp() {
		StringBuilder dir = new StringBuilder(HOME_PATH_FILES);
		dir.append(File.separator);
		dir.append(FOLDER_IMAGES);

		FileCreateTask f = new FileCreateTask(dir.toString(),newFileName(FILE_EXT_BITMAP));

		return f;
	}

