	public static FileCreateTask newSoundFile() {
		StringBuilder dir = new StringBuilder(HOME_PATH_FILES);
		dir.append(File.separator);
		dir.append(FOLDER_SOUND);

		FileCreateTask f = new FileCreateTask(dir.toString(),newFileName(FILE_EXT_SOUND_WAV));

		return f;
	}

